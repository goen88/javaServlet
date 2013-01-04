package com.rose.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_Session_Snoop
 */
@WebServlet("/Servlet_Session_Snoop")
public class Servlet_Session_Snoop extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Session_Snoop()
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
		Integer count = (Integer) session.getAttribute("snoop.count");
		if (null == count)
		{
			count = new Integer(1);
		} else
		{
			count = new Integer(count.intValue() + 1);

		}
		session.setAttribute("snoop.count", count);
		out.println("<HTML><HEAD><TITLE>SessionSnoop</TITLE></HEAD>");
		out.println("<BODY><H1>Session Snoop</H1>");
		out.print("You've visited this page" + count
				+ ((1 == count.intValue()) ? "time" : "times"));
		out.println("<P>");

		out.println("<H3>Here is your saved session data:</H3>");
		Enumeration<?> e = session.getAttributeNames();
		while (e.hasMoreElements())
		{
			String name = (String) e.nextElement();
			out.print(name + ":" + session.getAttribute(name));

		}
		out.println("<H3>Here are some vital stats on your session:</H3>");
		out.println("Session id: " + session.getId()
				+ " <I>(keep it secret)</I><BR>");
		out.println("New session: " + session.isNew() + "<BR>");
		out.println("Timeout: " + session.getMaxInactiveInterval());
		out.println("<I>(" + session.getMaxInactiveInterval() / 60
				+ " minutes)</I><BR>");
		out.println("Creation time: " + session.getCreationTime());
		out.println("<I>(" + new Date(session.getCreationTime()) + ")</I><BR>");
		out.println("Last access time: " + session.getLastAccessedTime());
		out.println("<I>(" + new Date(session.getLastAccessedTime())
				+ ")</I><BR>");

		out.println("Requested session ID from cookie: "
				+ request.isRequestedSessionIdFromCookie() + "<BR>");
		out.println("Requested session ID from URL: "
				+ request.isRequestedSessionIdFromURL() + "<BR>");
		out.println("Requested session ID valid: "
				+ request.isRequestedSessionIdValid() + "<BR>");

		out.println("<H3>Test URL Rewriting</H3>");
		out.println("Click <A HREF=\""
				+ response.encodeURL(request.getRequestURI()) + "\">here</A>");
		out.println("to test that session tracking works via URL");
		out.println("rewriting even when cookies aren't supported.");

		out.println("</BODY></HTML>");

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
