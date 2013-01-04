package com.rose.Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Cookie_Setter
 */
public class Servlet_Cookie_Setter extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Cookie_Setter()
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
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();
		boolean newCookie = false;

		if (null != cookies)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				if (cookies[i].getName().equals("mycookie"))
				{
					cookie = cookies[i];
				}
			}
		}
		if (null == cookie)
		{
			newCookie = true;
			int maxAge;
			try
			{
				maxAge = new Integer(getServletConfig().getInitParameter(
						"cookie-age")).intValue();
			} catch (Exception e)
			{
				maxAge = -1;
			}
			cookie = new Cookie("mycookie", "" + getNextCookieValue());
			cookie.setPath(request.getContextPath());
			cookie.setMaxAge(maxAge);
			response.addCookie(cookie);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cookie info</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h2> Information about the cookie named \"mycookie\"</h2>");
		out.print("Cookie value: " + cookie.getValue() + "<br/>");
		if (newCookie)
		{
			out.println("Cookie value" + cookie.getMaxAge() + "<br/>");
			out.print("Cookie Path: " + cookie.getPath() + "<br/>");
		}

		out.println("</body>");
		out.println("</html>");

		out.close();

	}

	private long getNextCookieValue()
	{
		return new Date().getTime();
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
