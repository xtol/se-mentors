
package com.practicum.se.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface ReSendCodeAsync {

	
	void checkHalfRegistered(String email, String code,
			AsyncCallback<String> callback);

	
	void checkRegistered(String email, AsyncCallback<String> callback);

}
