package com.practicum.se.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserDetailsServiceAsync {

	void getAddress(String email, AsyncCallback<String> callback);

	void getCity(String email, AsyncCallback<String> callback);

	void getCountry(String email, AsyncCallback<String> callback);

	void getDob(String email, AsyncCallback<String> callback);

	void getFname(String email, AsyncCallback<String> callback);

	void getLname(String email, AsyncCallback<String> callback);

	void getMname(String email, AsyncCallback<String> callback);

	void getPhone(String email, AsyncCallback<String> callback);

	void getPincode(String email, AsyncCallback<String> callback);

	void getUsername(String email, AsyncCallback<String> callback);

	void getPUsername(String email, AsyncCallback<Boolean> callback);

	void getPDob(String email, AsyncCallback<Boolean> callback);

	void getPCity(String email, AsyncCallback<Boolean> callback);

	void getPCountry(String email, AsyncCallback<Boolean> callback);

	void getPAddress(String email, AsyncCallback<Boolean> callback);

	void getPPhone(String email, AsyncCallback<Boolean> callback);

	void getPPincode(String email, AsyncCallback<Boolean> callback);

	void getPFname(String email, AsyncCallback<Boolean> callback);

	void getPMname(String email, AsyncCallback<Boolean> callback);

	void getPLname(String email, AsyncCallback<Boolean> callback);

	void updateuser(String firstName, String middleName, String lastName,
			String email, AsyncCallback<String> callback);

	void updateuser1(String email, String username, String country,
			String city, String pincode, String address, String ph_no,
			String date, String month, String year,
			AsyncCallback<String> callback);

	void updatepermission(String email, int firstName, int middleName,
			int lastname, int username, int country, int city, int pincode,
			int address, int ph_no, int dob, AsyncCallback<String> callback);

}
