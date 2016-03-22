package com.test;

class TryCatchFinallyFinalizer extends Thread{
	private void testMethod() throws InterruptedException {
		try {
			System.out.println("In try block");
			Thread.currentThread().sleep(100);
			throw new NullPointerException();
		} catch (NullPointerException npe) {
			System.out.println("In catch block");
		} finally {
			System.out.println("In finally block");
		}
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("In finalize block");
		super.finalize();
	}

	@Override
	public void run() {
		try {
			testMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class TestTryCatchFinallyFinalizer {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			TryCatchFinallyFinalizer finalizer = new TryCatchFinallyFinalizer();
			finalizer.start();
			finalizer.join();
			//Runtime.runFinalizersOnExit(true);
			Runtime.getRuntime().runFinalization();
		}
	}
	
	

}
