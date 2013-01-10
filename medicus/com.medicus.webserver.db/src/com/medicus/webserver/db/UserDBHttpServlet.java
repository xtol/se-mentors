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
@WebServlet("/UserDBHttpServlet")
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
		// This method will be called by clients when they wish to access the
		// data for a single user
		// or a list of all users
		System.out.println("doGet ds=" + ds);
		
		try {
			Collection<String> usernames = dbUtil.getUserNames();
			// For this, just write out the usernames
			response.getWriter().write(usernames.toString());
		} catch (SQLException e) {
			throw new ServletException("Database error accessing DataSource ds="+ds);
		}
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
