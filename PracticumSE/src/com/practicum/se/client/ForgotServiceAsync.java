package com.practicum.se.client;




import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ForgotServiceAsync {

	void check(String name,  AsyncCallback<String> callback);

}



