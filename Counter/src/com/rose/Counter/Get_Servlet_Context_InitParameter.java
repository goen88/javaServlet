package com.rose.Counter;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Get_Servlet_Context_InitParameter
 */
@WebServlet("/Get_Servlet_Context_InitParameter")
public class Get_Servlet_Context_InitParameter extends HttpServlet
{
	@Override
	public void init(ServletConfig config) throws ServletException
	{

		super.init(config);
		ServletContext context = getServletContext();
		dbName = context.getInitParameter("name");
		dbpassword = context.getInitParameter("password");
	}

	private static final long serialVersionUID = 1L;
	private String dbName = "";
	private String dbpassword = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Get_Servlet_Context_InitParameter()
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
		ServletOutputStream out = response.getOutputStream();
		response.setContentType("text/html");
		out.println("<html><head><title>Basic Servlet</title></head>");
		out.println("<body>Database username is  <b>" + dbName);
		out.println("</b><br>Database password is  <b>" + dbpassword + "</b>");
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
