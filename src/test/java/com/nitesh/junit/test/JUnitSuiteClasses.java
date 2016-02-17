package com.nitesh.junit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { TestCalculator.class, TestCalculator2.class })
public class JUnitSuiteClasses {

}
