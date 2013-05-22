package com.practicum.se.client;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SignupServiceAsync {
	
	void performSignup(String userCaptcha, AsyncCallback<Boolean> callback);
	
}
