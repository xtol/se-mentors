package com.practicum.se.client;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FriendDetailsServiceAsync {

	void FriendDetails(String email,
			AsyncCallback<HashMap<String, String>> callback);

}
