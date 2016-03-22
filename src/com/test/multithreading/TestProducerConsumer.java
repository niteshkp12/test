package com.test.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerPC implements Runnable {
	private BlockingQueue<String> blockingQueue = null;

	public void run() {
		System.out.println("ProducerPC.run()");
		while (true) {
			produce();
		}
	}

	private void produce() {
		System.out.println("ProducerPC.produce() " + Thread.currentThread().getName());
		try {
			blockingQueue.put("Nitesh");
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public ProducerPC(BlockingQueue<String> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}

}

class ConsumerPC implements Runnable {
	private BlockingQueue<String> blockingQueue = null;

	public ConsumerPC(BlockingQueue<String> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		System.out.println("ConsumerPC.run() ");
		while (true) {
			
			consume();
		}
	}

	private void consume() {
		System.err.println(blockingQueue.remainingCapacity());
		try {
			System.out.println(blockingQueue.take());
			
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class TestProducerConsumer {
	public static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(
			20);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread thread1 = new Thread(new ProducerPC(blockingQueue));
			thread1.setName("Producer " + i);
			Thread thread2 = new Thread(new ConsumerPC(blockingQueue));
			thread2.setName("Consumer " + i);
			thread1.start();
			thread2.start();
		}

	}
}
