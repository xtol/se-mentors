package com.practicum.se.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void check(String name, String password, AsyncCallback<String> callback);

}
