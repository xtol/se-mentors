package com.msit.jntu.hms.server;

import java.sql.*;

import com.msit.jntu.hms.client.GreetingService;
import com.msit.jntu.hms.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
GreetingService {


Connection con=null;
Statement st=null;


ResultSet rs=null;

String ss="no";
String url="jdbc:mysql://localhost:3306/test";


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

rs = st.executeQuery("select * from login where name='" + s1 + "' and password='" + s2+"'" );

if(rs.next())
{
ss="yes";
System.out.println(rs.getString(0));
System.out.println(rs.getString(1));
}

System.out.println(ss);

}
catch(SQLException e)
{
System.out.println("kill"+e.getMessage());

}
System.out.println(ss);

return ss;
}
@Override
public String newuser(String name, String password) 
{
String ss = "no";
call();


try
{
boolean ss1;
ss1 = st.execute("insert into login values('" + name+"','"+ password +"')");

if(ss1)
{


ss="yes";
}



}
catch(SQLException e)
{
System.out.println(e.getMessage());

}
return ss;


}
}
