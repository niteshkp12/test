package com.test.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Synchronised1 {
	public void Method1(int a) {
		synchronized (this) {
			a++;
			System.out.println("nitesh " + Thread.currentThread().getName()
					+ " :: " + a);
		}
	}
}

public class TestSynchronised {
	public static int inits;

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 7; i++) {
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					new Synchronised1().Method1(inits);
					inits++;
					System.out.println(inits);
				}
			});
		}
		executorService.shutdown();
	}
}
