package com.test.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * If you will run above program, you will notice that count value varies between
 * 5,6,7,8. The reason is because count++ is not an atomic operation. So by the
 * time one threads read it’s value and increment it by one, other thread has
 * read the older value leading to wrong result.
 */

public class TestAtomicInteger {

	public static void main(String[] args) throws InterruptedException {

		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
	}

}

class ProcessingThread implements Runnable {
	// private AtomicInteger count = new AtomicInteger();
	private int count;

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			// processSomething(i);
			// count.incrementAndGet();
			count++;
		}
	}

	public int getCount() {
		// return this.count.get();
		return count++;
	}

	private void processSomething(int i) {
		// processing some job
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
