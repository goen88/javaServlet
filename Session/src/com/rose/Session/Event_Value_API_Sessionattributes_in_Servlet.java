package com.rose.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.jms.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Servlet implementation class Event_Value_API_Sessionattributes_in_Servlet
 */
@WebServlet("/Event_Value_API_Sessionattributes_in_Servlet")
public class Event_Value_API_Sessionattributes_in_Servlet extends HttpServlet
{
	static final String COUNTER_KEY = "Counter.count";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Event_Value_API_Sessionattributes_in_Servlet()
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

		SessionObject o = new SessionObject(getServletContext());

		int count = 1;
		Integer i = (Integer) session.getAttribute(COUNTER_KEY);
		if (i != null)
		{
			count = i.intValue() + 1;
		}
		session.setAttribute(COUNTER_KEY, new Integer(count));
		Integer counter2 = (Integer) getServletContext().getAttribute(
				"counter2");
		if (null == counter2)
		{
			counter2 = new Integer(1);
		} else
		{
			counter2 = new Integer(counter2.intValue() + 1);
		}
		getServletContext().setAttribute("counter2", counter2);
		Integer counter = (Integer) session.getAttribute("counter");
		if (null == counter)
		{
			counter = new Integer(1);
			session.setAttribute("Binder.object", o);
		} else
		{
			counter = new Integer(counter.intValue() + 1);
		}
		session.setAttribute("counter", counter);
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>");
		out.println("Using Contexts");
		out.println("</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("Object bound to session " + "**********" + session.getId());
		out.println("Your session ID is <b>" + session.getId());
		out.println("</b> and you have hit this page <b>" + count
				+ "</b> time(s) during this browser session");

		out.println("<form method=GET action=\"" + request.getRequestURI()
				+ "\">");
		out.println("<input type=submit " + "value=\"Hit page again\">");
		out.println("</form>");
		out.print("<br/>");
		out.println("<H1>Using Contexts</H1>");

		out.println("Welcome! You have been here " + counter + " times.<BR>");

		out.println("Total page accesses: " + counter2 + "<BR>");

		if (session.isNew())
		{
			out.println("This is a new session.<BR>");
		} else
		{
			out.println("This is not a new session.<BR>");
		}

		out.println("The session ID: " + session.getId() + "<BR>");
		out.println("Last time accessed: "
				+ new Date(session.getLastAccessedTime()) + "<BR>");
		out.println("Creation time: " + new Date(session.getCreationTime())
				+ "<BR>");
		out.println("Timeout length: " + session.getMaxInactiveInterval()
				+ " seconds<BR>");

		out.println("</BODY>");
		out.println("</HTML>");

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

	class SessionObject implements HttpSessionBindingListener
	{
		ServletContext context;

		public SessionObject(ServletContext context)
		{

			this.context = context;
		}

		@Override
		public void valueBound(HttpSessionBindingEvent arg0)
		{
			context.log("" + (new Date()) + "Binding" + arg0.getName()
					+ arg0.getSession());

		}

		@Override
		public void valueUnbound(HttpSessionBindingEvent arg0)
		{
			context.log("" + (new Date()) + "UnBinding" + arg0.getName()
					+ arg0.getSession());

		}

	}
}
