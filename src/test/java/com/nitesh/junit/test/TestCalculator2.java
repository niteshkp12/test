package com.nitesh.junit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.nitesh.junit.Calculator2;

public class TestCalculator2 {
	public Calculator2 calculator2;

	@Before
	public void init() {
		calculator2 = new Calculator2();
	}

	@Test
	public void shouldMultiplyTwoNumber() {
		assertEquals(15, calculator2.multiply(5, 3));
	}

	@Test
	public void shouldDivideTwoNumbers() {
		assertEquals(2, calculator2.divide(10, 5));
	}

	@Test(expected = ArithmeticException.class)
	public void shouldThrowExceptionDivideyZero() {
		calculator2.divide(5, 0);
	}

	@Ignore
	@Test(timeout = 100)
	public void shouldTimeOutDivideOperatoin() {
		calculator2.divide(5, 0);
		while (true)
			;
	}
}
