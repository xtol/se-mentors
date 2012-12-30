package com.xtolmasters.examples.tomcat.realm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AuthorityDBUtil {

	public static final String DEFAULT_DBNAME = "authority";
	public static final String DEFAULT_CONNECTION_URL = "jdbc:mysql://localhost/"+DEFAULT_DBNAME+"?user=root";
	public static final String DEFAULT_USERTABLE = "users";
	public static final String DEFAULT_USERNAME_FIELD = "user_name";
	public static final String DEFAULT_USERPASS_FIELD = "user_pass";
	public static final String DEFAULT_ROLETABLE = "user_roles";
	public static final String DEFAULT_ROLENAME_FIELD = "role_name";
	
	protected String dbname = DEFAULT_DBNAME;
	protected String connectionURL = DEFAULT_CONNECTION_URL;

	protected String usertable = DEFAULT_USERTABLE;
	protected String usernamefield = DEFAULT_USERNAME_FIELD;
	protected String userpassfield = DEFAULT_USERPASS_FIELD;

	protected String roletable = DEFAULT_ROLETABLE;
	protected String rusernamefield = DEFAULT_USERNAME_FIELD;
	protected String rolenamefield = DEFAULT_ROLENAME_FIELD;
	
	public AuthorityDBUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
        	ex.printStackTrace(System.err);
         }
	}
	
	protected synchronized Connection getConnection(String connectionUrl) throws SQLException {
		return DriverManager.getConnection(connectionUrl);
	}
	
	protected Connection getConnection() throws SQLException {
		return getConnection(connectionURL);
	}
	
	protected boolean processArgs(String[] args) {
		for(int i=0; i < args.length; i++) {
			if ("-url".equals(args[i])) {
				this.connectionURL = args[i+1];
				i++;
			} else if ("-dbname".equals(args[i])) {
				this.dbname = args[i+1];
				i++;
			} else if ("-usertable".equals(args[i])) {
				this.usertable = args[i + 1];
				i++;
			} else if ("-roletable".equals(args[i])) {
				this.roletable = args[i + 1];
				i++;
			} else if ("- usernamefield".equals(args[i])) {
				this.usernamefield = args[i + 1];
				i++;
			} else if ("-userpassfield".equals(args[i])) {
				this.userpassfield = args[i + 1];
				i++;
			} else if ("-rusernamefield".equals(args[i])) {
				this.rusernamefield = args[i + 1];
				i++;
			} else if ("-rolenamefield".equals(args[i])) {
				this.rolenamefield = args[i + 1];
				i++;
			}
		}
		return true;
	}

}
