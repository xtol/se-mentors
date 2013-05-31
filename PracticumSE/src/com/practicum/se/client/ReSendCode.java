package com.practicum.se.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("code")
public interface ReSendCode  extends RemoteService {
	String checkRegistered(String email);
	String checkHalfRegistered(String email,String code);

}
