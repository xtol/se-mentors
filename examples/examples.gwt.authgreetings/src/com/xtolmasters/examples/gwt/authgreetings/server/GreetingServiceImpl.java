package com.xtolmasters.examples.gwt.authgreetings.server;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.xtolmasters.examples.gwt.authgreetings.client.GreetingService;
import com.xtolmasters.examples.gwt.authgreetings.shared.FieldVerifier;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	private static final String DB_RESOURCE_NAME = "jdbc/xtolmasters";

	@Resource(name = DB_RESOURCE_NAME)
	private DataSource ds;

	@SuppressWarnings("unused")
	private DataSource getDataSourceFromJNDI() {
		try {
			Context ctx = new InitialContext();
			return (DataSource) ctx.lookup("java:comp/env/" + DB_RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// XXX Add getting authenticated user and reporting it back
		String remoteUser = getThreadLocalRequest().getRemoteUser();

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent
				+ "<br><br>Authenticated User is: " + remoteUser
				+ "<br><br>DataSource is: " + ds + "<br>";
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	public void logoff() {
		HttpServletRequest request = getThreadLocalRequest();
		if (request.getRemoteUser() != null) {
			HttpSession session = request.getSession(false);
			if (session != null)
				session.invalidate();
		}
	}
}
