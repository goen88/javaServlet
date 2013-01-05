package com.rose.Counter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Servlet_ContextAttributeListener implements
		ServletContextAttributeListener, ServletContextListener

{

	private ServletContext context = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		log("contextDestroyed()");
		this.context = null;

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		this.context = arg0.getServletContext();
		log("contextInitialized");

	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0)
	{
		log("attributeAdded('" + arg0.getName() + "', '" + arg0.getValue()
				+ "')");

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0)
	{
		log("attributeRemoved('" + arg0.getName() + "', '" + arg0.getValue()
				+ "')");

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0)
	{
		log("attributeReplaced('" + arg0.getName() + "', '" + arg0.getValue()
				+ "')");

	}

	/**
	 * Log a message to the servlet context application log.
	 * 
	 * @param message
	 *            Message to be logged
	 */
	private void log(String message)
	{

		if (context != null)
			context.log("ContextListener: " + message);
		else
			System.out.println("ContextListener: " + message);

	}

	/**
	 * Log a message and associated exception to the servlet context application
	 * log.
	 * 
	 * @param message
	 *            Message to be logged
	 * @param throwable
	 *            Exception to be logged
	 */
	private void log(String message, Throwable throwable)
	{

		if (context != null)
			context.log("ContextListener: " + message, throwable);
		else
		{
			System.out.println("ContextListener: " + message);
			throwable.printStackTrace(System.out);
		}

	}

}
