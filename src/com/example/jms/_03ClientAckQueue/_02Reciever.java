package com.example.jms._03ClientAckQueue;

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
			session = con.createQueueSession(false, Session.CLIENT_ACKNOWLEDGE);
			receiver = session.createReceiver(queue);
			con.start();
			Message message = null;
			for(int i = 0; i < 5; i++){
				Message msg = receiver.receive();
				TextMessage textMessage = (TextMessage) msg;
				if(i == 3){
					message = msg;
				}
				System.out.println(textMessage.getText());
			}
			message.acknowledge();
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