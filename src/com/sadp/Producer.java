package com.sadp;

/**
 * 
 * Producer of the event
 * 
 * The producer is a thread. Its run method should producer some random events with one particular group id
 * and should publish that events to share location via produce() method.
 * 
 * @author skum73
 *
 */
public class Producer extends Thread {
	
	/**
	 * 
	 * This method should create the event to some shared location so that it is available for consumer to consume
	 * 
	 * @param e
	 */
	void produce(Event e) {
		//TODO : provide your logic here
	}
	
}
