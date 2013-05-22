package com.practicum.se.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("Registration")
public interface RegistrationService  extends RemoteService{
	
	String newuser(String firstName, String middleName,String lastName, String email, String code );
    String newuser1(String code_enter,String username, String gender,String country, String city, String pincode 
    		,String address,String ph_no,
			String date,String month, String year ,String password); 
    String check(String email,String code);
}
