package com.nitesh.junit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nitesh.junit.Calculator;

public class TestCalculator {

	private Calculator calculator;

	@Before
	public void init() {
		calculator = new Calculator();
//		User user = new User("dsa");
//		UserDao.save(user);
	}

	@Test
	public void ShouldAddTwoNumber() {
		assertEquals(8, calculator.add(5, 3));
	}

	@Test
	public void ShouldSubstractTwoNumbers() {
		assertEquals(3, calculator.substract(8, 5));
	}

	@Test
	public void isUserExist(){
//		assertEqual(true, User.isValidUser(user)));
	}
}
