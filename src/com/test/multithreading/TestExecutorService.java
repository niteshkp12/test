package com.test.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.*;

class BeeperControl {
	private final ScheduledExecutorService scheduler = Executors
			.newScheduledThreadPool(1);

	public void beepForAnHour() {
		final Runnable beeper = new Runnable() {
			public void run() {
				System.out.println("beep");
			}
		};
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(
				beeper, 1, 1, SECONDS);
		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
			}
		}, 1 * 2, SECONDS);
	}
}

class TestCallable implements Callable<List<String>> {

	@Override
	public java.util.List<String> call() throws Exception {
		System.out.println("TestCallable.call()");
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		return list;
	}

}

class TestThreadPoolExecutors {
	ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 0, 0, null, null);
}

public class TestExecutorService {
	public static void main(String[] args) {
		
		BeeperControl beeperControl = new BeeperControl();
		beeperControl.beepForAnHour();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				try {
					System.err.println(Thread.currentThread().getName());
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("hello");
			}
		});

		Future<java.util.List<String>> future = executorService
				.submit(new TestCallable());
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();

		// try {
		// executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println("nitesh");
		System.err.println(Thread.currentThread().getName());
	}
}
