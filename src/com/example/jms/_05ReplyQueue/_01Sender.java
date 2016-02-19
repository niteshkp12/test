package com.example.jms._05ReplyQueue;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class _01Sender {
	public static void main(String[] args) {
		try {
			InitialContext context = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) context
					.lookup("QueueConnectionFactory");
			Queue queue = (Queue) context.lookup("dynamicQueues/testQ");
			// Sending a message to the target queue
			final QueueConnection con = factory.createQueueConnection();
			final QueueSession session = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);
			// Set the reply Queue to the message
			final Queue replyQueue = (Queue) context.lookup("dynamicQueues/replyQ");
			TextMessage message = session.createTextMessage();
			message.setJMSReplyTo(replyQueue);
			//Initiate a thread to read reply  
			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						QueueReceiver receiver = session.createReceiver(replyQueue);
						con.start();
						while (true) {
							Message msg = receiver.receive();
							TextMessage textMessage = (TextMessage) msg;
							System.out.println("Response: " + textMessage.getText());
						}
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();

			Scanner scanner = new Scanner(System.in);
			String str = null;
			do {
				str = scanner.nextLine();
				message.setText(str);
				sender.send(message);
				System.out.println(message.getJMSMessageID());
			} while (!"bye".equals(str));
			sender.close();
			t.join();
			session.close();
			con.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}