package com.msit.jntu.hms.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void check(String name, String password, AsyncCallback<String> callback);

	void newuser(String name, String password, AsyncCallback<String> callback)
			throws IllegalArgumentException;

}
