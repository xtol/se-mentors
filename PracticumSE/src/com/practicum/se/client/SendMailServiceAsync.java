package com.practicum.se.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SendMailServiceAsync {

	void sendMail(String sendto, String code, AsyncCallback<String> callback);

}
