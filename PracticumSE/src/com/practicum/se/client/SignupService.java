package com.practicum.se.client;



import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("signup")
public interface SignupService extends RemoteService {
	
	boolean performSignup(String userCaptcha);
	
}
