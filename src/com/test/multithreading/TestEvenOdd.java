package com.test.multithreading;

public class TestEvenOdd {
	public static void main(String[] args) {
		Object lock = new Object();
		boolean isEven = false;
		new Thread(new Even(lock, isEven)).start();
		new Thread(new Odd(lock, isEven)).start();

	}
}

class Even implements Runnable {
	private Object lock;
	private boolean isEven;
	private int number = 2;

	public Even(Object lock, boolean isEven) {
		this.lock = lock;
		this.isEven = isEven;
	}

	@Override
	public void run() {
		while (number<20) {
			try {
				even();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void even() throws InterruptedException {
		synchronized (lock) {
			while (!isEven) {
				lock.wait();
			}
			System.out.println("Even: " + number);
			isEven = true;
			number += 2;
			lock.notifyAll();
		}
	}
}

class Odd implements Runnable {
	private Object lock;
	private boolean isEven;
	private int number = 1;

	public Odd(Object lock, boolean isEven) {
		this.lock = lock;
		this.isEven = isEven;
	}

	@Override
	public void run() {
		while (number<20) {
			try {
				odd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void odd() throws InterruptedException {
		synchronized (lock) {
			while (isEven) {
				lock.wait();
			}
			System.out.println("Odd: " + number);
			number += 2;
			isEven =false;
			lock.notifyAll();
		}
	}
}