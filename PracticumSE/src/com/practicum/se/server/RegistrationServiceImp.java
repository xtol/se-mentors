package com.practicum.se.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.practicum.se.client.RegistrationService;


@SuppressWarnings("serial")
public class RegistrationServiceImp extends RemoteServiceServlet implements RegistrationService
{

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
	public String newuser(String firstName, String middleName,String lastName, String email, String code )
	{
		String ss = "no";
		call();
		System.out.println("hi in new user");

		try {
			boolean ss1;
			
			ss1 = st.execute("insert into reg_page values('" + firstName + "','"
					+ middleName + "','" + lastName + "','"
					+ email + "','"
					+ code + "')");
			
			
			//Window.alert("hi in new user");
			System.out.println("hi in new user---ss1"+ss1);
				if(!ss1)
				{
				ss = "yes";
				
				}
				

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return ss;

	}

	@Override
	public String newuser1( String username, String gender,
			String country, String city, String pincode, String address,
			String ph_no, String date, String month, String year,
			String password,String email) {
		
		// TODO Auto-generated method stub
		String ss = "no";
		call();
		
		//System.out.println("hi in new user");

		try {
			System.out.println("hi in new user"+date+"->"+month+"->"+year);
			boolean ss2;
			ss2=st.execute("insert into reg_page2 values('"+ username + "','" + gender + "','"+ country + "','"
					+ city + "','"+ pincode + "','"+ address + "','"
					+ ph_no + "','"+ date.toString() + "','"
					+ month + "','"
					+ year + "','"
					+ password + "','"
					+ email + "')");
			
			//Window.alert("hi in new user");
			//System.out.println("hi in new user");
			
			st.execute("insert into permission values('" + email + "',1,1,1,1,1,1,1,1,1,1,1,1,1)");
				ss = "yes";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return ss;
		
	}



	@Override
	public String check(String email, String code) {
		// TODO Auto-generated method stub

		call();


		try
		{

		rs = st.executeQuery("select * from reg_page where email='" + email + "' and code_enter='" + code+"'" );

		if(rs.next())
		{
		ss="yes";
		System.out.println(rs.getString(0));
		System.out.println(rs.getString(1));
		}
		else
		{
			ss="no";
		System.out.println(ss);
		}
		}
		catch(SQLException e)
		{
		System.out.println("kill"+e.getMessage());

		}


		return ss;
}
}
