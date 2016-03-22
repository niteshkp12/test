package com.test.multithreading.concurrency;

class DeadLock1 {
	public synchronized void Method1(DeadLock2 deadLock2) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		deadLock2.PrintValue2();
	}

	public synchronized void PrintValue1() {
		System.out.println("In A");
	}
}

class DeadLock2 {
	public synchronized void Method2(DeadLock1 deadLock1) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		deadLock1.PrintValue1();
	}

	public synchronized void PrintValue2() {
		System.out.println("In B");
	}
}

public class TestDeadLock extends Thread {
	DeadLock1 deadLock1 = new DeadLock1();
	DeadLock2 deadLock2 = new DeadLock2();

	public TestDeadLock() {
		this.start();
		deadLock2.Method2(deadLock1);
	}

	public static void main(String[] args) {
		System.out.println("TestDeadLock.main()");
		new TestDeadLock();
	}

	public void run() {
		System.out.println("Inside run");
		deadLock1.Method1(deadLock2);
	}

}