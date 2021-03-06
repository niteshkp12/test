package com.example.jms._03ClientAckQueue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class _03AsynchronousReciever {
	public static void main(String[] args) {
		try {
			readTextQueue("dynamicQueues/testQ");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readTextQueue(String topicName) throws JMSException {
		QueueConnection con = null;
		QueueSession session = null;
		QueueReceiver receiver = null;
		try {
			InitialContext context = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("QueueConnectionFactory");
			Queue queue = (Queue) context.lookup(topicName);

			con = factory.createQueueConnection();
			session = con.createQueueSession(false, Session.CLIENT_ACKNOWLEDGE);
			receiver = session.createReceiver(queue);

			con.start();

			receiver.setMessageListener(new MessageListener() {
				public void onMessage(Message message) {
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						try {
							System.out.println(textMessage.getText());
							message.acknowledge();
						} catch (JMSException e) {
							e.printStackTrace();
						}
					}
				}
			});
			while (true) {

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