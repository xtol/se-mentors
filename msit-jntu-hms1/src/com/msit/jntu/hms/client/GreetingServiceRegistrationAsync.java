package com.msit.jntu.hms.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceRegistrationAsync {

	void check(String firstName, String middleName, String lastName,
			String email, String reEmail, AsyncCallback<String> callback);

	void newuser(String firstName, String middleName, String lastName,
			String email, String reEmail, AsyncCallback<String> callback);

}
