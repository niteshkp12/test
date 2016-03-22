package com.test.multithreading.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class TestRentrantLock {
	static ReentrantLock lock = new ReentrantLock();
	private static int count;

	private static void FirstThread() {
		lock.lock();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	private static void SecondThread() {
		lock.lock();
		increment();
		lock.unlock();
	}

	private static void increment() {
		count++;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.print(1);
					FirstThread();
					SecondThread();
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.print(2);
				}
			}
		};

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Nitesh: " + count);
	}
}
