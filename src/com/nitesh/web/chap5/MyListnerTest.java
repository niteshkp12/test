package com.nitesh.web.chap5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyListnerTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("MyListnerTest.doGet()");
		Dog dog = (Dog) getServletContext().getAttribute("dog");
		PrintWriter out = resp.getWriter();
		out.println("Dog breed is::  " + dog.getBreed());

		getServletContext().setAttribute("foo", 21);
		getServletContext().setAttribute("boo", 22);

		out.println(getServletContext().getAttribute("foo"));
		out.println(getServletContext().getAttribute("boo"));
	}
}