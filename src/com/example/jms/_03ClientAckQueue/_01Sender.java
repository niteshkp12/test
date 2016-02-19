package com.example.jms._03ClientAckQueue;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
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
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("QueueConnectionFactory");
			Queue queue = (Queue) context.lookup("dynamicQueues/testQ");

			QueueConnection con = factory.createQueueConnection();
			QueueSession session = con.createQueueSession(false, Session.CLIENT_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);

			TextMessage message = session.createTextMessage();
			Scanner scanner = new Scanner(System.in);
			for(int i = 0; i < 5; i++) {
				message.setText(scanner.nextLine());
				sender.send(message);
			}
			sender.close();
			session.close();
			con.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
