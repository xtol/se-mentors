package com.practicum.se.server;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.practicum.se.client.ReturnService;

import java.sql.*;
@SuppressWarnings("serial")
public class ReturnServiceImp extends RemoteServiceServlet implements
ReturnService {


Connection con=null;
Statement st=null;
//Statement =null;


ResultSet rs=null;

String ss="no";
String password=null;
//System.out.println(password);
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
System.out.println("hello connection done");
}
catch(SQLException e)
{
System.out.println(e.getMessage());
}
}
@Override
public String pass(String c1) 
{
// TODO Auto-generated method stub

call();


try
{

rs = st.executeQuery("select password from reg_page2 where email='" + c1 + "'" );

if(rs.next())
{
ss="yes";
password = rs.getString("password");


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
System.out.println(password);
return password;

}

}
