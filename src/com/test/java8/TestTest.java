package com.test.java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTest {
	public static void main(String[] args) {
		System.out.println("TestTest.main()");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		String dateStr = dateFormat.format(date);
		System.err.println(dateStr);
		
		DateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy");
		Date s = null;
		System.err.println(s);
	}

	void method1() {

	}

	String method12() {
		return "";
	}

}
