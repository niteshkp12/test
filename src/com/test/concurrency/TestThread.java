package com.test.concurrency;

class Threads extends Thread {
	void print(int number) {
		for (int i = 0; i < 10; i++) {
			System.out.println(number + i);
			try {
				int a = (int) (Math.random() + 1);
				this.sleep(a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("interrupted");
				e.printStackTrace();
			}
		}
	}

	public void run() {
		System.out.println("Threads.run()");
		print(10);
	}
}

class Runnables implements Runnable {
	void print(int number) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Name: "+ Thread.currentThread().getName());
			try {
				int a = (int) (Math.random() + 1);
				Thread.currentThread().sleep(a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("interrupted");
				e.printStackTrace();
			}
		}
	}

	public void run() {
		System.out.println("Runnables.run(): "+ Thread.currentThread().getName());
		print(20);
	}
}

public class TestThread {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("TestThread.main()");
//		Threads t1 = new Threads();
//		Threads t2 = new Threads();
//		Threads t3 = new Threads();
//		t1.start();
//		t2.start();
//		t3.start();
		
		Runnables r1 = new Runnables();
		Runnables r2 = new Runnables();
		Runnables r3 = new Runnables();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		
		t1.start();
		
		t2.start();
		t3.start();
		
//		t1.join();
		t2.interrupt();
		t3.join();
	}
}
