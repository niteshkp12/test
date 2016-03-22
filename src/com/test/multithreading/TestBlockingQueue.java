package com.test.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Consumers implements Runnable{
	private BlockingQueue<String> blockingQueue = null;
	
	public Consumers(BlockingQueue<String> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}
	public void consume() {
		System.out.println("Consumed");
		while(true){
			try {
				String s = blockingQueue.take();
				System.out.println(s + " :: " + blockingQueue.size());
				Thread.currentThread().sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void run() {
		consume();
	}
}

class Producers implements Runnable{
	private BlockingQueue<String> blockingQueue = null;
	
	public Producers(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	public void produce(){
		System.out.println("Produced");
	}

	public void run() {
		while(true){
			try {
				blockingQueue.put(new Random().nextInt(100)+"");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class TestBlockingQueue {
	public static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
	public static void main(String[] args) {
		Thread t1 = new Thread(new Producers(blockingQueue));
		Thread t2 = new Thread(new Consumers(blockingQueue));
		t1.start();
		t2.start();
	}
}
