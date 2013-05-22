package com.practicum.se.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.practicum.se.client.LoginService;

import java.sql.*;
public class LoginServiceImp extends RemoteServiceServlet implements
LoginService {


Connection con=null;
Statement st=null;


ResultSet rs=null;

String ss="no";
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
public String check(String s1, String s2) 
{
// TODO Auto-generated method stub

call();


try
{

rs = st.executeQuery("select * from reg_page2 where email='" + s1 + "' and password='" + s2+"'" );

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
