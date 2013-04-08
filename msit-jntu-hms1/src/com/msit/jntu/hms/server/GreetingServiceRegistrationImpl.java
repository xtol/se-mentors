package com.msit.jntu.hms.server;

import java.sql.*;

import com.msit.jntu.hms.client.GreetingService;
import com.msit.jntu.hms.client.GreetingServiceRegistration;
import com.msit.jntu.hms.shared.FieldVerifier;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceRegistrationImpl extends RemoteServiceServlet implements
GreetingServiceRegistration {

	Connection con = null;
	Statement st = null;

	ResultSet rs = null;

	String ss = "no";
	String url = "jdbc:mysql://localhost:3306/hospitalmanagement";

	public void call() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, "root", "root");
			st = con.createStatement();
			System.out.println("hello connection done");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String check(String firstName, String middleName,String lastName, String email, String reEmail) {
		// TODO Auto-generated method stub

		call();

		try {

			rs = st.executeQuery("select * from registration_page where email='" + email+ "'");

			if (rs.next()) {
				ss = "yes";
				System.out.println(rs.getString(0));
				System.out.println(rs.getString(1));
			}

			System.out.println(ss);

		} catch (SQLException e) {
			System.out.println("kill" + e.getMessage());

		}
		System.out.println(ss);

		return ss;
	}

	@Override
	public String newuser(String firstName, String middleName,String lastName, String email, String reEmail) {
		String ss = "no";
		call();
		System.out.println("hi in new user");

		try {
			boolean ss1;
			ss1 = st.execute("insert into registration_page values('" + firstName + "','"
					+ middleName + "','" + lastName + "','"
					+ email + "','"
					+ reEmail + "')");
			//Window.alert("hi in new user");
			System.out.println("hi in new user");
			//if (ss1) {

				ss = "yes";
			//}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return ss;

	}
}
