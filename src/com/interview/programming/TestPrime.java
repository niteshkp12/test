package com.interview.programming;

public class TestPrime {
	public static void main(String[] args) {
		int number = 234;
		for (int i = 1; i < 100; i++) {
			if (isPrime(i)) {
				System.out.println("IsEven " + i + " :: " + isPrime(i));
			}
		}
		isPrime(47);
	}
//	http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
		
	private static boolean isPrime(int number) {
		if (number % 2 == 0)
			return false;
		for (int i = 3; i * i <= number; i = i + 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}
}
