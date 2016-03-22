package com.test.java8;

public class TestTest {
	public static void main(String[] args) {

		System.out.println("TestTest.main()");
		int[] array = { 2, 5, 3, 4, 2, 3, 4, 3 };
		int num = oddNumberProblem(array);
		System.err.println("num: " + num);
		
		System.out.println(true && (32 & 31)==0);
		System.out.println((2!=0));
		
	}

	private static int oddNumberProblem(int[] array) {
		int result=0;
		for(int i : array){
			result = result^i;
			System.err.println(result);
		}
		return result;
			
	}

}

