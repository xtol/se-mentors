package com.practicum.se.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Forgot")
public interface ForgotService extends RemoteService {
	String check(String name);

	// String check(String name);
}
