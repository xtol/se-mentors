package com.practicum.se.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationServiceAsync {

	
	void newuser(String firstName, String middleName, String lastName,
			String email, String code, AsyncCallback<String> callback);

	void newuser1(String code_enter, String username, String gender,
			String country, String city, String pincode, String address,
			String ph_no, String date, String month, String year,
			String password, AsyncCallback<String> callback);

	void check(String email, String code, AsyncCallback<String> callback);

}
