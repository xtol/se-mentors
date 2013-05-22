package com.practicum.se.client;



import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MailServiceAsync {

	void sendMail(String sendto, String password, AsyncCallback<String> callback);

}
