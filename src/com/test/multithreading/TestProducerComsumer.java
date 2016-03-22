package com.test.multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class Consumer implements Runnable {
	private ArrayList<String> list = null;

	public Consumer(ArrayList<String> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		synchronized (list) {
			while (true) {
				while (list.isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				consume();
			}
		}
	}

	private void consume() {
		Iterator iterator = (Iterator) list.iterator();
		while (iterator.hasNext()) {
			System.err.println(iterator.next());
			iterator.remove();
		}
	}

}

class Producer implements Runnable {

	private ArrayList<String> list = null;

	public Producer(ArrayList<String> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		synchronized (list) {
			while (true) {
				while (list.size() == 10) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				produce();
				list.notify();
			}
		}
	}

	private void produce() {
		Random random = new Random();
		int temp = random.nextInt(100);
		synchronized (list) {
			list.add(" " + temp);
			System.out.println("Produced :: " + temp);
		}

	}
}

public class TestProducerComsumer {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList(10);
		Thread t1 = new Thread(new Producer(list));
		Thread t2 = new Thread(new Consumer(list));
		t1.start();
		t2.start();

	}
}
