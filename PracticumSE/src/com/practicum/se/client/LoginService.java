package com.practicum.se.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("Login")
public interface LoginService  extends RemoteService {
	String check(String name,String password);
}
