package com.practicum.se.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.practicum.se.client.UserDetailsService;


public class UserDetailsServiceImp extends RemoteServiceServlet implements UserDetailsService{


Connection con=null;
Statement st=null;


ResultSet rs=null;

String ss=null;
String url="jdbc:mysql://localhost:3306/hospitalmanagement";


public void call()
{
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(ClassNotFoundException e)
{
System.out.print(e.getMessage());
}
try
{
con=DriverManager.getConnection(url, "root","root");
st=con.createStatement();
//System.out.println("hello connection done in uds");
}
catch(SQLException e)
{
System.out.println(e.getMessage());
}
}
	
	
	@Override
	public String getUsername(String email) {
		
		call();


		try
		{
			//System.out.println("hello in ud uname");
		rs = st.executeQuery("select username from reg_page2 where email='" + email + "'" );

		if(rs.next())
		{
			//System.out.println("in uds"+email);
			
		ss=rs.getString(1);
		//System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}

	@Override
	public String getDob(String email) {
		
		call();


		try
		{
			//System.out.println("hello in ud dob");
		rs = st.executeQuery("select date,month,year from reg_page2 where email='" + email + "'" );

		if(rs.next())
		{
			//System.out.println("in uds"+email);
			
		ss=rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3);
		//System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds dob"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}

	@Override
	public String getCity(String email) {
		
		call();


		try
		{
			//System.out.println("hello in ud city");
		rs = st.executeQuery("select city from reg_page2 where email='" + email + "'" );

		if(rs.next())
		{
			//System.out.println("in uds"+email);
			
		ss=rs.getString(1);
		//System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds city"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}

	@Override
	public String getCountry(String email) {
		
		call();


		try
		{
			//System.out.println("hello in ud country");
		rs = st.executeQuery("select country from reg_page2 where email='" + email + "'" );

		if(rs.next())
		{
			System.out.println("in uds"+email);
			
		ss=rs.getString(1);
		System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds country"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}

	@Override
	public String getAddress(String email) {
		
		call();


		try
		{
			System.out.println("hello in ud address");
		rs = st.executeQuery("select address from reg_page2 where email='" + email + "'" );

		if(rs.next())
		{
			System.out.println("in uds"+email);
			
		ss=rs.getString(1);
		System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds address"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}

	@Override
	public String getPhone(String email) {
		
		call();


		try
		{
			System.out.println("hello in ud phone");
		rs = st.executeQuery("select ph_no from reg_page2 where email='" + email + "'" );

		if(rs.next())
		{
			System.out.println("in uds"+email);
			
		ss=rs.getString(1);
		System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds phone"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}

	@Override
	public String getPincode(String email) {
		
		call();


		try
		{
			System.out.println("hello in ud pincode");
		rs = st.executeQuery("select pincode from reg_page2 where email='" + email + "'" );

		if(rs.next())
		{
			System.out.println("in uds"+email);
			
		ss=rs.getString(1);
		System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds pincode"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}

	@Override
	public String getFname(String email) {
		
		call();


		try
		{
			System.out.println("hello in ud fname");
		rs = st.executeQuery("select firstname from reg_page where email='" + email + "'" );

		if(rs.next())
		{
			System.out.println("in uds"+email);
			
		ss=rs.getString(1);
		System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds fname"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}

	@Override
	public String getMname(String email) {
		
		call();


		try
		{
			System.out.println("hello in ud mname");
		rs = st.executeQuery("select middlename from reg_page where email='" + email + "'" );

		if(rs.next())
		{
			System.out.println("in uds"+email);
			
		ss=rs.getString(1);
		System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds mname"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}

	@Override
	public String getLname(String email) {
		
		call();


		try
		{
			System.out.println("hello in ud lname");
		rs = st.executeQuery("select lastname from reg_page where email='" + email + "'" );

		if(rs.next())
		{
			System.out.println("in uds"+email);
			
		ss=rs.getString(1);
		System.out.println("\n"+ss+"\n");
		
		}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());

		}
		
		// TODO Auto-generated method stub
		return ss;
	}


	@Override
	public boolean getPUsername(String email) {
		call();
		try
		{	rs = st.executeQuery("select username from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean getPDob(String email) {
		call();
		try
		{	rs = st.executeQuery("select date from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean getPCity(String email) {
		call();
		try
		{	rs = st.executeQuery("select city from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	
	}


	@Override
	public boolean getPCountry(String email) {
		call();
		try
		{	rs = st.executeQuery("select country from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	
	}


	@Override
	public boolean getPAddress(String email) {
		call();
		try
		{	rs = st.executeQuery("select address from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	
	}


	@Override
	public boolean getPPhone(String email) {
		call();
		try
		{	rs = st.executeQuery("select ph_no from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	
	}


	@Override
	public boolean getPPincode(String email) {
		call();
		try
		{	rs = st.executeQuery("select pincode from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	
	}


	@Override
	public boolean getPFname(String email) {
		call();
		try
		{	rs = st.executeQuery("select firstName from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	
	}


	@Override
	public boolean getPMname(String email) {
		call();
		try
		{	rs = st.executeQuery("select middleName from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	
	}


	@Override
	public boolean getPLname(String email) {
		call();
		try
		{	rs = st.executeQuery("select lastname from permission where email='" + email + "'" );
	
			if(rs.next())
			{
				if(rs.getString(1).equals("1"))
				{
					return true;
				}
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds lname"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return false;
	
	}


	@Override
	public String updateuser(String firstName, String middleName,
			String lastName,String email) {
		call();
		boolean ss;
		String ss1="no";
		try
		{	ss=st.execute("update reg_page set firstName='" + firstName + "',middleName='"+middleName+"',lastname='"+lastName+"' where email='" + email + "'" );
	
			if(!ss)
			{
				ss1="yes";
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds updating set&&&----->"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return ss1;
	}


	@Override
	public String updateuser1(String emai,String username, String country, String city,
			String pincode, String address, String ph_no, String date,
			String month, String year) {
		// TODO Auto-generated method stub
		call();
		boolean ss;
		String ss1="no";
		try
		{	ss=st.execute("update reg_page2 set username='" + username + "',country='"+country+"',city='"+city+"',pincode='"+pincode+"',address='"+address+"',ph_no='"+ph_no+"' where email='" + emai + "'" );
	
			if(!ss)
			{
				ss1="yes";
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds updating set reg_2&&&----->"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return ss1;
	}


	@Override
	public String updatepermission(String email, int firstName,
			int  middleName, int  lastname, int  username,
			int  country, int  city, int  pincode, int  address,
			int  ph_no, int  dob) {
		// TODO Auto-generated method stub
		call();
		boolean ss;
		String ss1="no";
		try
		{	ss=st.execute("update permission set firstName='" + firstName + "',middleName='"+middleName+"'," +
				"lastname='"+lastname+"',username='" + username + "',country='"+country+"'," +
				"city='"+city+"',pincode='"+pincode+"',address='"+address+"',ph_no='"+ph_no+"' where email='" + email + "'" );
	
			if(!ss)
			{
				ss1="yes";
			}
		
		}
		catch(SQLException e)
		{
		System.out.println("kill---uds updating set reg_2&&&----->"+e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return ss1;
	}

}
