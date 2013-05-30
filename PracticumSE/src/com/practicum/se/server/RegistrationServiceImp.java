package com.practicum.se.server;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicum.se.client.RegistrationService;

@SuppressWarnings("serial")
public class RegistrationServiceImp extends DataSourceRemoteServiceServlet implements
		RegistrationService {

	private ResultSet rs;
	private String ss;

	@Override
	public String newuser(String firstName, String middleName, String lastName,
			String email, String code) {
		String ss = "no";
		System.out.println("hi in new user");

		try {
			boolean ss1;

			ss1 = createStatement().execute("insert into reg_page values('" + firstName
					+ "','" + middleName + "','" + lastName + "','" + email
					+ "','" + code + "')");

			// Window.alert("hi in new user");
			System.out.println("hi in new user---ss1" + ss1);
			if (!ss1) {
				ss = "yes";

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return ss;

	}

	@Override
	public String newuser1(String username, String gender, String country,
			String city, String pincode, String address, String ph_no,
			String date, String month, String year, String password,
			String email) {

		// TODO Auto-generated method stub
		String ss = "no";

		// System.out.println("hi in new user");

		try {
			System.out.println("hi in new user" + date + "->" + month + "->"
					+ year);
			createStatement().execute("insert into reg_page2 values('" + username
					+ "','" + gender + "','" + country + "','" + city + "','"
					+ pincode + "','" + address + "','" + ph_no + "','"
					+ date.toString() + "','" + month + "','" + year + "','"
					+ password + "','" + email + "')");

			// Window.alert("hi in new user");
			// System.out.println("hi in new user");

			createStatement().execute("insert into permission values('" + email
					+ "',1,1,1,1,1,1,1,1,1,1,1,1,1)");
			ss = "yes";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return ss;

	}

	@Override
	public String check(String email, String code) {
		try {

			rs = createStatement().executeQuery("select * from reg_page where email='" + email
					+ "' and code_enter='" + code + "'");

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
