package com.practicum.se.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("sendMail")
public interface SendMailService extends RemoteService {
	String sendMail(String sendto, String code);
}