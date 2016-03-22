package com.test.multithreading;

public class TestJoin {
	public static void main(String[] args) {

		Thread thread = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("run: " + Thread.currentThread().getName());
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Finish: "
						+ Thread.currentThread().getName());
			}
		};
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("run: " + Thread.currentThread().getName());
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Finish: "
						+ Thread.currentThread().getName());
			}
		};
		Thread thread3 = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("run: " + Thread.currentThread().getName());
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Finish: "
						+ Thread.currentThread().getName());
			}
		};
		try {
			thread.start();
			thread.join();
			thread2.start();
			thread2.join();
			thread3.start();
			System.out.println("TestJoin.main()");
			thread3.join();
			System.out.println("TestJoin.main()");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ThreadOrdering {
    public static void main(String[] args) {

        class MyRunnable implements Runnable{
            private final int threadnumber;

            MyRunnable(int threadnumber){
                this.threadnumber = threadnumber;
            }

            public void run() {
                System.out.println(threadnumber);
            }
        }

        for(int i=1; i<=10; i++){
            new Thread(new MyRunnable(i)).start();
        }
    }
}