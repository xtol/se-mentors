package com.practicum.se.server;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicum.se.client.LoginService;

public class LoginServiceImp extends DataSourceRemoteServiceServlet implements
		LoginService {

	private static final long serialVersionUID = -1670710851578845238L;
	private ResultSet rs;
	private String ss;

	@Override
	public String check(String s1, String s2) {
		try {
			rs = createStatement().executeQuery("select * from reg_page2 where email='" + s1
					+ "' and password='" + s2 + "'");
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
