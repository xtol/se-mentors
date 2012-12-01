package com.xtolmasters.examples.tomcat.realm.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class AddUser extends MySQLDBUtil {

	String username;
	String password;
	Collection<String> userroles;
	
	protected void processArgs(String[] args) {
		super.processArgs(args);
		for(int i=0; i < args.length; i++) {
			if ("-username".equals(args[i])) {
				this.username = args[i+1];
				i++;
			} else if ("-password".equals(args[i])) {
				this.password = args[i+1];
				i++;
			} else if ("-roles".equals(args[i])) {
				this.userroles = parseList(args[i+1]);
				i++;
			}
		}
	}

	private List<String> parseList(String string) {
		StringTokenizer st = new StringTokenizer(string,",");
		List<String> result = new ArrayList<String>();
		while (st.hasMoreTokens()) result.add(st.nextToken());
		return result;
	}


}
