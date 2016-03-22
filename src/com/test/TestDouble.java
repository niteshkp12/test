package com.test;

import java.text.NumberFormat;
import java.util.Locale;

public class TestDouble {
	public static void main(String[] args) {
		System.out.println("TestDouble.main()");
		double d = 2.02;
		System.out.println(d += .25);
		d = +.2;
		d = +.2;
		d = +.2;
		d = +.2;
		System.out.println((d += .25));
		for (int i = 0; i < 5; i++) {
			d = d + .2;
		}
		System.err.println(d);

		System.err.println(formatRupee(3.9));

	}

	public static String formatRupee(double value) {
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("yi", "in"));
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(5);
		return format.format(value);
	}
}
