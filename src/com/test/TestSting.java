package com.test;

import java.io.IOException;


public class TestSting{
	public static void main(String[] args) {
		try{
			exampleMethod();
		}catch (final IOException e) {
			System.out.println("nitesh");
		}
	}

	private static void exampleMethod() throws IOException{
		try{
			System.out.println("1");
			throw new NullPointerException();
			//System.out.println("2");
		}finally{
			throw new IOException();
		}
	}
}
