package com.practicum.se.server;

import java.sql.*;
import java.util.ArrayList;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.practicum.se.client.SearchFriendService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SearchFriend extends RemoteServiceServlet implements
SearchFriendService {

	Connection con = null;
	Statement st = null;

	ResultSet rs = null;
	ArrayList<String>  ss = new ArrayList<String>();

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
	public ArrayList<String> getNames(String email) {
		// TODO Auto-generated method stub
		call();

		try {

			rs = st.executeQuery(" select username from reg_page2 where not username='" + email+ "'");

			while (rs.next()) 
			{
				
				ss.add(rs.getString(1));
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getString(1));
			}

			//System.out.println(ss);

		} catch (SQLException e) {
			System.out.println("kill" + e.getMessage());

		}
		
		return ss;
		//return null;
	}

	
}

