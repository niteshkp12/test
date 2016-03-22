package com.test;

public class TestTry {

	public static void main(String[] args) {
		try {
			System.out.println(1);
		} finally{
			try {
				System.out.println(2);
			} finally{
				System.out.println(3);
			}
		}
	}

}
