
package com.practicum.se.client;

import java.util.ArrayList;

import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface SearchFriendServiceAsync {
	Request getNames(String email, AsyncCallback<ArrayList<String>> callback);

}
