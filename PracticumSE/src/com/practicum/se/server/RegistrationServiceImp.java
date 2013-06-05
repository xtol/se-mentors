package com.practicum.se.server;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicum.se.client.RegistrationService;

@SuppressWarnings("serial")
public class RegistrationServiceImp extends DataSourceRemoteServiceServlet implements
		RegistrationService {

	private ResultSet rs;
	private String ss;

	
	
	public String newuser(String firstName, String middleName,String lastName, String email, String code )
	{
		String ss = "no";
				try {
			boolean ss1;
			
			rs = createStatement().executeQuery(" select * from reg_page where email='" + email+ "'");
			if(rs.next())
			{
				return ss;
			}
			else{
			ss1 = createStatement().execute("insert into reg_page values('" + firstName + "','"
					+ middleName + "','" + lastName + "','"
					+ email + "','"
					+ code + "')");
				if(!ss1)
				{
				ss = "yes";
				
				}
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
		try {
			createStatement().execute("insert into reg_page2 values('" + username
					+ "','" + gender + "','" + country + "','" + city + "','"
					+ pincode + "','" + address + "','" + ph_no + "','"
					+ date.toString() + "','" + month + "','" + year + "','"
					+ password + "','" + email + "')");
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

		}

		return ss;
	}
}
