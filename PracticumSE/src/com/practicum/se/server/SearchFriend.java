package com.practicum.se.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.practicum.se.client.SearchFriendService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SearchFriend extends DataSourceRemoteServiceServlet implements
		SearchFriendService {

	private ResultSet rs;
	private ArrayList<String> ss = new ArrayList<String>();

	@Override
	public ArrayList<String> getNames(String email) {
		try {

			rs = createStatement().executeQuery(" select username from reg_page2 where not username='"
					+ email + "'");

			while (rs.next()) {

				ss.add(rs.getString(1));
			}
		} catch (SQLException e) {

		}

		return ss;
	}

}
