package com.rose.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class
 * Servlet_Session_Max_Inactive_Interval_Create_Check
 */
@WebServlet("/Servlet_Session_Max_Inactive_Interval_Create_Check")
public class Servlet_Session_Max_Inactive_Interval_Create_Check extends
		HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Session_Max_Inactive_Interval_Create_Check()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Date creationTime = new Date(session.getCreationTime());
		Date lastAccessed = new Date(session.getLastAccessedTime());
		Date now = new Date();
		DateFormat formatter = DateFormat.getDateTimeInstance(
				DateFormat.MEDIUM, DateFormat.MEDIUM);
		out.println("<HTML><HEAD><TITLE>SessionTimer</TITLE></HEAD>");
		out.println("<BODY><H1>Session Timer</H1>");
		out.println("<h2>Session Creation and Last-Accessed Time</h2>");
		out.println("The time and date now is: " + formatter.format(now)
				+ "<br><br>");
		out.println("The session creation time: HttpSession.getCreationTime( ): "
				+ formatter.format(creationTime) + "<br><br>");
		out.println("The last time the session was accessed: HttpSession.getLastAccessedTime( ): "
				+ formatter.format(lastAccessed)+ "<br/>");
		out.println("The previous timeout was"
				+ session.getMaxInactiveInterval());
		session.setMaxInactiveInterval(2 * 60 * 60);
		out.print("The previous timeout was" + session.getMaxInactiveInterval());
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

}
