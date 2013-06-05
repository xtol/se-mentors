package com.practicum.se.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Return")
public interface ReturnService extends RemoteService {
	String pass(String password);
	

}
