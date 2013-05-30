package com.practicum.se.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Mail")
public interface MailService extends RemoteService {
	String sendMail(String sendto, String password);
}