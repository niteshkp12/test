package com.nitesh.web.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
//@WebServlet(description = "A Simple Servlert", urlPatterns = { "/SimpleServletPath" })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SimpleServlet.doGet()");
//		PrintWriter writer = response.getWriter();
//		writer.println("<H3> Hello in Html<H3>");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
//		dispatcher.forward(request, response);
		
		response.sendRedirect("www.google.com");
//		ServletOutputStream outputStream = response.getOutputStream();
		
	}



}