package com.practicum.se.client;




import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ReturnServiceAsync {

	void pass(String password,  AsyncCallback<String> callback);
	//void pass(AsyncCallback callback);

}



