
package com.practicum.se.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("UDetails")
public interface UserDetailsService extends RemoteService {
	String getUsername(String email);

	String getDob(String email);

	String getCity(String email);

	String getCountry(String email);

	String getAddress(String email);

	String getPhone(String email);

	String getPincode(String email);

	String getFname(String email);

	String getMname(String email);

	String getLname(String email);

	boolean getPUsername(String email);

	boolean getPDob(String email);

	boolean getPCity(String email);

	boolean getPCountry(String email);

	boolean getPAddress(String email);

	boolean getPPhone(String email);

	boolean getPPincode(String email);

	boolean getPFname(String email);

	boolean getPMname(String email);

	boolean getPLname(String email);

	String updateuser(String firstName, String middleName, String lastName,
			String email);

	String updateuser1(String email, String username, String country,
			String city, String pincode, String address, String ph_no,
			String date, String month, String year);

	String updatepermission(String email, int firstName, int middleName,
			int lastname, int username, int country, int city, int pincode,
			int address, int ph_no, int dob);

}
