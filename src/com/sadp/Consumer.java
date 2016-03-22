package com.sadp;

/**
 * 
 * A simple consumer of the events. The special thing about this consumer is that this consumer consumes the
 * events of same group Id. So, if there are 10 different events of 2 different groups i.e. total 20 events, 
 * then it should consume the for one group.
 * 
 * This consumer is a thread. The run method should keep on calling the consume method and print the GroupEvent.
 * 
 * PLEASE NOTE THAT THE CONSUMER SHOULD NOT WAIT FOR CERTAIN NUMBER OF EVENTS TO APPEAR. IT SHOULD CONSUME BASED
 * ON WHAT IS AVAILABLE IN THE QUEUE.
 * 
 * FOR INSTANCE, 
 * 
 * 	if the queue has following events
 * 
 * 	eventId		GroupId		Payload
 * 
 * 		1			3		first
 * 		2			4		second
 * 		3			3		third
 * 		4			7		fourth
 * 		5			3		fifth
 * 		6			4		sixth
 * 		7			4		seventh
 * 
 * then, it should just take the first event i.e. event with Id = 1 and take all the events that having same group Id i.e
 * events with Id - 1, 3, & 5. It should remove them from the queue, merge the payload to be "first third fifth" and create
 * a GroupEvent with this details.
 * 
 * This is to be used in very high volume environment so you should consider the performance.
 * 
 * @author skum73
 *
 */
public class Consumer extends Thread {
	
	/**
	 * consumes the list of events, merges the events with same groupId and returns the GroupEvent
	 * 
	 * @return
	 */
	GroupEvent consume() {
		// TODO: provide logic to read events and merge them
		return null;
	}
	
}
