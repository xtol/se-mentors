package com.practicum.se.server;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicum.se.client.ForgotService;

@SuppressWarnings("serial")
public class ForgotServiceImp extends DataSourceRemoteServiceServlet implements
		ForgotService {

	private ResultSet rs;
	private String ss;

	@Override
	public String check(String c1) {
		try {
			rs = createStatement().executeQuery("select * from reg_page2 where email='" + c1
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
		}
		return ss;
	}

}
