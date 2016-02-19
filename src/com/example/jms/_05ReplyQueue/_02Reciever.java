package com.example.jms._05ReplyQueue;

import javax.jms.Destination;
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
			for (int i = 0; i < 5; i++) {
				Message msg = receiver.receive();
				TextMessage textMessage = (TextMessage) msg;
				System.out.println(textMessage.getText());
				Destination dest = textMessage.getJMSReplyTo();
				if (dest != null) {
					QueueSender sender = session.createSender((Queue) dest);
					TextMessage replyMsg = session.createTextMessage("Reply");
					replyMsg.setJMSCorrelationID(textMessage.getJMSMessageID());
					sender.send(replyMsg);
					sender.close();
				}
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