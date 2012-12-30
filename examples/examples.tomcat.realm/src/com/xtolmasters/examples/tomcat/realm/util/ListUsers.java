package com.xtolmasters.examples.tomcat.realm.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListUsers extends AuthorityDBUtil {

	public ListUsers(String[] args) {
		processArgs(args);
	}
	
	public static void main(String[] args) {
		ListUsers listUsers = new ListUsers(args);
		listUsers.run();
	}

	public void run() {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Connection conn = getConnection();
			statement = conn.createStatement();
			if (statement.execute("SELECT user_name from users")) {
				resultSet = statement.getResultSet();
			}
			while (resultSet.next()) {
				System.out.println("USERNAME="+resultSet.getString("user_name"));
			}
			conn.close();
		} catch (SQLException e) {
		    System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
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
	}
}
