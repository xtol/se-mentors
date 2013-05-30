package com.practicum.se.server;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicum.se.client.ReturnService;

@SuppressWarnings("serial")
public class ReturnServiceImp extends DataSourceRemoteServiceServlet implements
		ReturnService {

	private ResultSet rs = null;
	private String ss = "no";
	private String password = null;

	@Override
	public String pass(String c1) {
		try {

			rs = createStatement().executeQuery("select password from reg_page2 where email='"
					+ c1 + "'");

			if (rs.next()) {
				ss = "yes";
				password = rs.getString("password");

			} else {
				ss = "no";
				System.out.println(ss);
			}
		} catch (SQLException e) {
			System.out.println("kill" + e.getMessage());

		}
		System.out.println(password);
		return password;

	}

}
