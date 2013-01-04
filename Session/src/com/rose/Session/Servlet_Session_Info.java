package com.rose.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_Session_Info
 */
@WebServlet("/Servlet_Session_Info")
public class Servlet_Session_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet_Session_Info() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		 out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Simple Session Tracker</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h2>Session Info</h2>");
	        out.println("session Id: " + session.getId() + "<br/>");
	        out.println("The Session timeout period is " + session.getMaxInactiveInterval());
	        
	        out.println("Now changine it to 20 minutes.<br/>");
	        session.setMaxInactiveInterval(20 * 60);
	        out.print("The session Timeout period is now " + session.getMaxInactiveInterval());
	        out.println("</body>");
	        out.println("</html>");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
