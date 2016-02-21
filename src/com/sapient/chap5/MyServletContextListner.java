package com.sapient.chap5;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListner implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyServletContextListner.contextInitialized()");
		ServletContext context = sce.getServletContext();
		String breed = (String) context.getInitParameter("breed");

		Dog dog = new Dog(breed);
		context.setAttribute("dog", dog);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
