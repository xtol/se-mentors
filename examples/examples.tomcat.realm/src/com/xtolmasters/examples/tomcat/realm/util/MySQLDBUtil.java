package com.xtolmasters.examples.tomcat.realm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBUtil {

	protected String connectionURL = "jdbc:mysql://localhost/authority?user=root";

	public MySQLDBUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
        	ex.printStackTrace(System.err);
         }
	}
	
	protected Connection getConnection(String connectionUrl) throws SQLException {
		return DriverManager.getConnection(connectionUrl);
	}
	
	protected Connection getConnection() throws SQLException {
		return getConnection(connectionURL);
	}
	
	protected void processArgs(String[] args) {
		for(int i=0; i < args.length; i++) {
			if ("-url".equals(args[i])) {
				this.connectionURL = args[i+1];
				i++;
			}
		}
	}

}
