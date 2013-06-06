package com.practicum.se.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DataSourceRemoteServiceServlet extends RemoteServiceServlet {

	private static final long serialVersionUID = 277703817658330511L;

	private static final String DBNAME = "hospitalmanagement";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "root";
	private static final String JDBCURL = "jdbc:mysql://localhost:3306/"
			+ DBNAME;
	private static final String DATARESOURCE_NAME = "jdbc/" + DBNAME;
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	@Resource(name = DATARESOURCE_NAME)
	private DataSource ds;

	private DataSource getDataSourceFromJNDI() {
		try {
			Context ctx = new InitialContext();
			return (DataSource) ctx
					.lookup("java:comp/env/" + DATARESOURCE_NAME);
		} catch (NamingException e) {
			return null;
		}
	}

	protected synchronized DataSource getDataSource() {
		if (ds == null)
			ds = getDataSourceFromJNDI();
		return ds;
	}

	protected synchronized Connection getConnection() throws SQLException {
		DataSource ds = getDataSource();
		if (ds != null)
			return ds.getConnection();
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Could not load driver=" + DRIVER_CLASS,e);
		}
		return DriverManager.getConnection(JDBCURL, DBUSER, DBPASSWORD);
	}

	protected Statement createStatement() throws SQLException {
		return getConnection().createStatement();
	}
}
