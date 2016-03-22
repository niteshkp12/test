package com.test.multithreading;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(100);
		return Thread.currentThread().getName();
	}

}

public class TestCallableTest {
	public static void main(String[] args) {
		System.out.println("TestCallable.main()");

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Callable<String> callable = new MyCallable();

		List<Future<String>> futures = new ArrayList<Future<String>>();

		for (int i = 0; i < 10; i++) {
			Future<String> future = executorService.submit(callable);
			futures.add(future);
			try {
				System.out.println(future.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (Future<String> future : futures) {
			try {
				System.err.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
