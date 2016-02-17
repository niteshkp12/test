package com.nitesh.junit.mock;

public class HeatEngine {
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;

	public HeatEngine() {
	}

	public int getStatus(ICity city) {
		int temp = city.getTemperature();
		if (temp < 50)
			return LOW;
		else if (temp > 50 && temp < 70)
			return MEDIUM;
		else
			return HIGH;
	}
}
