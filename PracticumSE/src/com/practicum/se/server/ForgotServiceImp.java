package com.practicum.se.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.practicum.se.client.ForgotService;

@SuppressWarnings("serial")
public class ForgotServiceImp extends RemoteServiceServlet implements
		ForgotService {

	Connection con = null;
	Statement st = null;
	// Statement =null;

	ResultSet rs = null;

	String ss = "no";
	// String nn="no";
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
	public String check(String c1) {
		// TODO Auto-generated method stub

		call();

		try {

			rs = st.executeQuery("select * from reg_page2 where email='" + c1
					+ "'");

			if (rs.next()) {
				ss = "yes";
				System.out.println(rs.getString(0));
				System.out.println(rs.getString(1));
			} else {
				ss = "no";
				System.out.println(ss);
			}
		} catch (SQLException e) {
			System.out.println("kill" + e.getMessage());

		}

		return ss;
	}

}
