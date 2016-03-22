package com.test.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestBasicExecutor extends Thread {

	public static void main(String[] args) throws InterruptedException {
		TestBasicExecutor thread = new TestBasicExecutor();
		thread.start();

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(thread);
	}

	@Override
	public void run() {
		System.out.println("Thread name: " + Thread.currentThread().getName());
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}

}
