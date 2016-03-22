package com.interview.programming;

public class TestReverseNumber {
	public static void main(String[] args) {
		System.out.println("TestReverseNumber.main()");
		int number = 12345;
		int reverseNumber = reverseNumber(number);
		System.out.println(reverseNumber);
	}

	private static int reverseNumber(int number) {
		int newNumber = 0;
		while(number > 0){
			
			int reminder = number%10;
			newNumber = newNumber * 10 +reminder;
			number = number / 10;
		}
		return newNumber;
	}
}
