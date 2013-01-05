package com.rose.Counter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deployment_Descriptor
 */
@WebServlet("/Deployment_Descriptor")
public class Deployment_Descriptor extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Deployment_Descriptor()
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
		ServletContext context = getServletContext();
		String displayName = context.getServletContextName();
		if (null == displayName)
		{
			displayName = "(no display-name element defined)";
		}
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Web Application Properties");
		out.println("</title>");
		out.println("</head><body>");
		out.println("<h1>Web Application Properties</h2>");
		out.println("<br>Name: " + displayName);
		out.println("<br>Context: " + request.getContextPath());

		out.println("<h2><center>");
		out.println("Initialization Parameters</center></h2>");
		out.println("<br>");

		out.println("<center><table border width=80%>");
		Enumeration<String> e = context.getInitParameterNames();
		while (e.hasMoreElements())
		{
			String name = (String) e.nextElement();
			out.println("<tr>");
			out.println("<td>" + name + "</td>");
			out.println("<td>" + context.getInitParameter(name) + "</td>");
			out.println("</tr>");

		}
		out.println("</table></center>");

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
