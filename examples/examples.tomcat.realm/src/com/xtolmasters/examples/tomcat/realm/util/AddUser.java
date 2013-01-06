package com.xtolmasters.examples.tomcat.realm.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class AddUser extends XTOLMastersDBUtil {

	String username;
	String password;
	Collection<String> userroles;

	protected boolean processArgs(String[] args) {
		boolean superResult = super.processArgs(args);
		if (!superResult)
			return superResult;
		for (int i = 0; i < args.length; i++) {
			if ("-username".equals(args[i])) {
				this.username = args[i + 1];
				i++;
			} else if ("-password".equals(args[i])) {
				this.password = args[i + 1];
				i++;
			} else if ("-roles".equals(args[i])) {
				this.userroles = parseList(args[i + 1]);
				i++;
			}
		}
		if (this.username == null) {
			System.out
					.println("Error in input:  Must set username via -username command line argument");
			usage();
			return false;
		}
		if (this.password == null) {
			System.out
					.println("Error in input:  Must set password via -password command line argument");
			usage();
			return false;
		}
		if (this.userroles == null) {
			System.out
					.println("Error in input:  Must set userroles via -roles command line argument");
			usage();
			return false;
		}
		return true;
	}

	private List<String> parseList(String string) {
		StringTokenizer st = new StringTokenizer(string, ",");
		List<String> result = new ArrayList<String>();
		while (st.hasMoreTokens())
			result.add(st.nextToken());
		return result;
	}

	private boolean addUser() throws SQLException {
		Connection connection = getConnection();
		StringBuffer insertSQL = new StringBuffer("INSERT INTO `");
		insertSQL.append(dbname).append("`.`").append(usertable).append("` (`");
		insertSQL.append(usernamefield).append("`, `").append(userpassfield)
				.append("`) ");
		insertSQL.append("VALUES ('").append(username).append("', '")
				.append(password).append("');");
		PreparedStatement statement = connection.prepareStatement(insertSQL
				.toString());
		return statement.execute();
	}

	private boolean addRole(String rolename) throws SQLException {
		Connection connection = getConnection();
		StringBuffer insertSQL = new StringBuffer("INSERT INTO `");
		insertSQL.append(dbname).append("`.`").append(roletable).append("` (`");
		insertSQL.append(rusernamefield).append("`, `").append(rolenamefield)
				.append("`) ");
		insertSQL.append("VALUES ('").append(username).append("', '")
				.append(rolename).append("');");
		PreparedStatement statement = connection.prepareStatement(insertSQL
				.toString());
		return statement.execute();

	}

	private void addRoles() throws SQLException {
		if (userroles == null)
			throw new NullPointerException(
					"Userroles is null...no user roles to add");
		for (String userrole : userroles) {
			addRole(userrole);
		}
	}

	private static void usage() {
		System.out
				.println("Usage:  AddUser -username <username> -password <password> -roles <role1,role2,role3,etc>");
	}

	public static void main(String[] args) throws Exception {
		AddUser addUser = new AddUser();
		if (args.length < 6)
			usage();
		boolean parseResult = addUser.processArgs(args);
		if (!parseResult)
			return;
		addUser.addUser();
		addUser.addRoles();
	}
}
