package com.msit.jntu.hms.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greetRegistration")
public interface GreetingServiceRegistration extends RemoteService {
	String check(String firstName, String middleName, String lastName,
			String email, String reEmail);

	String newuser(String firstName, String middleName, String lastName,
			String email, String reEmail);
}
