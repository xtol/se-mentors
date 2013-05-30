package com.practicum.se.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.practicum.se.client.FriendDetailsService;

public class FriendDetailsServiceImp extends RemoteServiceServlet implements
		FriendDetailsService {
	Connection con = null;
	Statement st = null;
	Statement st1 = null;

	ResultSet rs = null;
	ResultSet rs1 = null;

	Statement st2 = null;
	ResultSet rs2 = null;

	HashMap<String, String> hm = new HashMap<String, String>();
	String url = "jdbc:mysql://localhost:3306/hospitalmanagement";

	String email = null;

	public void call() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, "root", "root");
			st = con.createStatement();
			st1 = con.createStatement();
			st2 = con.createStatement();
			System.out.println("hello connection done fd");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public HashMap<String, String> FriendDetails(String uname) {
		// TODO Auto-generated method stub
		call();

		try

		{
			hm.clear();
			System.out.println("---->" + uname);
			rs2 = st2
					.executeQuery("select email from reg_page2 where username='"
							+ uname + "'");
			if (rs2.next()) {
				email = rs2.getString(1);

			}

			rs = st.executeQuery("select * from permission where email='"
					+ email + "'");

			if (rs.next()) {

				if (rs.getString(2).equals("1")) {

					rs1 = st1
							.executeQuery("select firstName from reg_page where email='"
									+ email + "'");
					if (rs1.next()) {
						hm.put("firstname", rs1.getString(1));
						System.out.println("ffff---->" + rs1.getString(1));
					}

				}

				if (rs.getString(3).equals("1")) {

					rs1 = st1
							.executeQuery("select middleName from reg_page where email='"
									+ email + "'");

					if (rs1.next()) {
						if (!rs1.getString(1).endsWith(""))
							hm.put("middlename", rs1.getString(1));
						System.out.println("ffff---->" + rs1.getString(1));
					}
				}

				if (rs.getString(4).equals("1")) {
					rs1 = st1
							.executeQuery("select lastname from reg_page where email='"
									+ email + "'");
					if (rs1.next())
						hm.put("lastname", rs1.getString(1));
					System.out.println("ffff---->" + rs1.getString(1));
				}

				if (rs.getString(5).equals("1")) {
					rs1 = st1
							.executeQuery("select username from reg_page2 where email='"
									+ email + "'");
					if (rs1.next())
						hm.put("username", rs1.getString(1));
					System.out.println("ffff---->" + rs1.getString(1));
				}

				if (rs.getString(6).equals("1")) {
					rs1 = st1
							.executeQuery("select gender from reg_page2 where email='"
									+ email + "'");
					if (rs1.next())
						hm.put("gender", rs1.getString(1));
					System.out.println("ffff---->" + rs1.getString(1));
				}

				if (rs.getString(7).equals("1")) {
					rs1 = st1
							.executeQuery("select country from reg_page2 where email='"
									+ email + "'");
					if (rs1.next())
						hm.put("country", rs1.getString(1));
					System.out.println("ffff---->" + rs1.getString(1));
				}

				if (rs.getString(8).equals("1")) {
					System.out.println("city");
					rs1 = st1
							.executeQuery("select city from reg_page2 where email='"
									+ email + "'");
					if (rs1.next())
						hm.put("city", rs1.getString(1));
					System.out.println("ffff---->" + rs1.getString(1));
				}

				if (rs.getString(9).equals("1")) {
					rs1 = st1
							.executeQuery("select pincode from reg_page2 where email='"
									+ email + "'");
					if (rs1.next())
						hm.put("pincode", rs1.getString(1));
					System.out.println("ffff---->" + rs1.getString(1));
				}

				if (rs.getString(10).equals("1")) {
					rs1 = st1
							.executeQuery("select address from reg_page2 where email='"
									+ email + "'");
					if (rs1.next())
						hm.put("address", rs1.getString(1));
					System.out.println("ffff---->" + rs1.getString(1));
				}

				if (rs.getString(11).equals("1")) {
					rs1 = st1
							.executeQuery("select ph_no from reg_page2 where email='"
									+ email + "'");
					if (rs1.next())
						hm.put("phonenum", rs1.getString(1));
					System.out.println("ffff---->" + rs1.getString(1));
				}

				if (rs.getString(12).equals("1")
						&& rs.getString(13).equals("1")
						&& rs.getString(14).equals("1")) {
					// System.out.println("for fname"+rs.getString(3));
					rs1 = st1
							.executeQuery("select date,month,year from reg_page2 where email='"
									+ email + "'");
					if (rs1.next())
						hm.put("dob", rs1.getString(1) + "-" + rs1.getString(2)
								+ "-" + rs1.getString(3));
					System.out.println("ffff---->" + rs1.getString(1));
					// System.out.println("for fname"+rs1.getString(3));
				}

				/*
				 * Set<?> set = hm.entrySet(); // Get an iterator Iterator<?> i
				 * = set.iterator(); // Display elements while(i.hasNext()) {
				 * Map.Entry me = (Map.Entry)i.next();
				 * System.out.print(me.getKey() + ": ");
				 * System.out.println(me.getValue()); }
				 */
			} else {

			}
		} catch (SQLException e) {
			System.out.println("kill" + e.getMessage());

		}

		return hm;
	}

}
