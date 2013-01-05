package com.rose.Counter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Static_Field_As_Counter
 */
@WebServlet("/Servlet_Static_Field_As_Counter")
public class Servlet_Static_Field_As_Counter extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	static int classCount = 0;
	int count = 0;
	static Hashtable<String, HttpServlet> instances = new Hashtable<>();

	/**
	 * Default constructor.
	 */
	public Servlet_Static_Field_As_Counter()
	{
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
		count++;
		out.println("Since loading, this servlet instance has been accessed "
				+ count + " times.<br/>");
		instances.put("this", this);
		out.println("There are currently " + instances.size() + "instances<br/>");
		classCount++;
		out.println("Across all instances, this servlet class has been "
				+ "accessed " + classCount + " times.<br/>");
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
