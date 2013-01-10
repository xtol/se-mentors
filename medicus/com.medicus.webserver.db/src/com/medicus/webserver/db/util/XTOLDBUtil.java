package com.medicus.webserver.db.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

public class XTOLDBUtil {

	private DataSource ds;

	public XTOLDBUtil(DataSource ds) {
		this.ds = ds;
	}

	public Collection<String> getUserNames() throws SQLException {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<String> userNames = new ArrayList<String>();
		try {
			conn = ds.getConnection();
			statement = conn.createStatement();
			if (statement.execute("SELECT user_name from users"))
				resultSet = statement.getResultSet();

			while (resultSet.next())
				userNames.add(resultSet.getString("user_name"));
			conn.close();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// ignore
				}
				resultSet = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// ignore
				}
				statement = null;
			}
		}
		return userNames;
	}

}
