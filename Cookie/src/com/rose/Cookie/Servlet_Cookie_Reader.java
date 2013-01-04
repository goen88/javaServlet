package com.rose.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Cookie_Reader
 */
@WebServlet("/Servlet_Cookie_Reader")
public class Servlet_Cookie_Reader extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Cookie_Reader()
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
		boolean hasCookies = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			hasCookies = true;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Cookie information</title>");
			out.println("</head>");
			out.println("<body>");
			if (hasCookies)
			{
				out.println("<h2> The name and value of each found cookie</h2>");
				for (int i = 0; i < cookies.length; i++)
				{
					cookie = cookies[i];
					out.println("Name of cookie #" + (i + 1) + ": "
							+ cookie.getName() + "<br>");
					out.println("Value of cookie #" + (i + 1) + ": "
							+ cookie.getValue() + "<br><br>");
				}
			} else
			{
				out.println("<h2> This request did not include any cookies</h2>");
			}
			out.println("</body>");
			out.println("</html>");

			out.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
