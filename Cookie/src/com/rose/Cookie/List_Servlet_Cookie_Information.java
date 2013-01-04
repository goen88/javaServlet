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
 * Servlet implementation class List_Servlet_Cookie_Information
 */
@WebServlet("/List_Servlet_Cookie_Information")
public class List_Servlet_Cookie_Information extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public List_Servlet_Cookie_Information()
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
		request.getSession();
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Cookie Information</title>");
		out.println("</head>");
		out.println("<body>");

		if ((null == cookies) || (0 == cookies.length))
		{
			out.println("<center><h1>NOCookies found</h1>");
		} else
		{
			out.print("<center><h1>Cookies found</h1>");
			for (int i = 0; i < cookies.length; i++)
			{
				Cookie c = cookies[i];
				out.print(c.getName() + "::" + c.getMaxAge() + "<ba/>");
			}
			out.print("</table></center>");
		}
		out.println("</body>");
		out.println("</html>");
		out.flush();

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
