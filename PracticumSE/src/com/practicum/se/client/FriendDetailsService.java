package com.practicum.se.client;

import java.util.HashMap;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("FDetails")
public interface FriendDetailsService  extends RemoteService {
	HashMap<String, String>FriendDetails(String email);
}
