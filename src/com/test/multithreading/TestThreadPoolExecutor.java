package com.test.multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class WorkerThread implements Runnable {

	private ThreadPoolExecutor executor;

	public WorkerThread(ThreadPoolExecutor executor) {
		super();
		this.executor = executor;
	}

	@Override
	public void run() {
		System.err.println("nitesh");
		try {
			System.out
					.println(String
							.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
									this.executor.getPoolSize(),
									this.executor.getCorePoolSize(),
									this.executor.getActiveCount(),
									this.executor.getCompletedTaskCount(),
									this.executor.getTaskCount(),
									this.executor.isShutdown(),
									this.executor.isTerminated()));
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.err.println("Reject task: " + r.toString());
	}

}

public class TestThreadPoolExecutor {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		System.out.println("TestTest.main()");
		ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 20, 60,
				TimeUnit.NANOSECONDS, new LinkedBlockingQueue<Runnable>(),
				Executors.defaultThreadFactory(),
				new RejectedExecutionHandlerImpl());

		for (int i = 0; i < 10; i++) {
			executor.submit(new WorkerThread(executor));
		}
		executor.shutdown();
		while (executor.isTerminated()) {
			System.out.println("TestTest.terminationed()");
		}

	}
}
