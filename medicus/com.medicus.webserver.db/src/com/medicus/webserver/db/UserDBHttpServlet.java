package com.medicus.webserver.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.medicus.webserver.db.util.XTOLDBUtil;

/**
 * Servlet implementation class UserDBHttpServlet
 */
@WebServlet("/Users")
public class UserDBHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/xtolmasters")
	private DataSource ds;
	private XTOLDBUtil dbUtil;

	@Override
	public void init() throws ServletException {
		super.init();
		this.dbUtil = new XTOLDBUtil(ds);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Get authenticated user
		String user = request.getRemoteUser();
		// Get usernames via dbUtil
		Collection<String> usernames = null;
		try {
			usernames = dbUtil.getUserNames();
		} catch (SQLException e) {
			throw new ServletException("Database error accessing DataSource ds="+ds);
		}
		
		response.getWriter().write("<h2>Logged in user is: "+user+"</hr><br>");
		response.getWriter().write("<h2>Usernames from db: "+usernames.toString()+"</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
