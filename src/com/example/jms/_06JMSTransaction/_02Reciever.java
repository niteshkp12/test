package com.example.jms._06JMSTransaction;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class _02Reciever {
	public static void main(String[] args) {
		try {
			readTextQueue("dynamicQueues/testQ");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readTextQueue(String queueName) throws JMSException {
		QueueConnection con = null;
		QueueSession session = null;
		QueueReceiver receiver = null;
		try {
			InitialContext context = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("QueueConnectionFactory");
			Queue queue = (Queue) context.lookup(queueName);
			con = factory.createQueueConnection();
			session = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			receiver = session.createReceiver(queue);
			con.start();
			while (true) {
				// Blocking call. Wait until message is available on the queue.
				Message message = receiver.receive();
				// Wait for 1 millisecond
				// receiver.receive(1);
				// Non Blocking call. Read a message only if a message is present on the queue
				// receiver.receiveNoWait();
				TextMessage textMessage = (TextMessage) message;
				System.out.println(textMessage.getText());
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			receiver.close();
			session.close();
			con.close();
		}
	}
}