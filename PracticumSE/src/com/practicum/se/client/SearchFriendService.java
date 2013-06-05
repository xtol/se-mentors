
package com.practicum.se.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("searchFriend")
public interface SearchFriendService extends RemoteService {

	ArrayList<String> getNames(String email);

}
