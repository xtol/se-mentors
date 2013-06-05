package com.practicum.se.server;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicum.se.client.ReturnService;

@SuppressWarnings("serial")
public class ReturnServiceImp extends DataSourceRemoteServiceServlet implements
		ReturnService {

	private ResultSet rs = null;
	private String password = null;

	@Override
	public String pass(String c1) {
		try {

			rs = createStatement().executeQuery("select password from reg_page2 where email='"
					+ c1 + "'");

			if (rs.next()) {
				password = rs.getString("password");

			} else {
			}
		} catch (SQLException e) {

		}
		return password;

	}

}
