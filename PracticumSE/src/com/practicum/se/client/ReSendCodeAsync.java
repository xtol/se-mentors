/**
 * 
 */
package com.practicum.se.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author sajja sai prasanna
 *
 */
public interface ReSendCodeAsync {

	/**
	 * 
	 * @see com.practicum.se.client.ReSendCode#checkHalfRegistered(java.lang.String, java.lang.String)
	 */
	void checkHalfRegistered(String email, String code,
			AsyncCallback<String> callback);

	/**
	 * 
	 * @see com.practicum.se.client.ReSendCode#checkRegistered(java.lang.String)
	 */
	void checkRegistered(String email, AsyncCallback<String> callback);

}
