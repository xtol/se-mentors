package com.practicum.se.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.practicum.se.client.ReSendCode;

public class ReSendCodeImp extends DataSourceRemoteServiceServlet implements
ReSendCode{
	private static final long serialVersionUID = 1L;
	Connection con = null;

	ResultSet rs = null;


	

	@Override
	public String checkRegistered(String email) {
		// TODO Auto-generated method stub
		try {
			
			rs = createStatement().executeQuery("select * from reg_page2 where email='"+email+"'");
		System.out.println("in ReSendCOde--->"+email);
		if(rs.next())
		{
			return "yes";
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

	@Override
	public String checkHalfRegistered(String email, String code) {
		// TODO Auto-generated method stub
		try {
			rs = createStatement().executeQuery(" select * from reg_page where email='" +email+ "'");
			if(rs.next())
			{
				
				System.out.println(rs.getString(1));
				return "yes";
				
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

}
