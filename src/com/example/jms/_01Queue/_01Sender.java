package com.example.jms._01Queue;

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
		Scanner scanner = null;
		try {
			InitialContext context = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) context
					.lookup("QueueConnectionFactory");
			Queue queue = (Queue) context.lookup("dynamicQueues/testQ");

			QueueConnection con = factory.createQueueConnection();
			QueueSession session = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);

			TextMessage message = session.createTextMessage();
			scanner = new Scanner(System.in);
			for (int i = 0;; i++) {
				// We can set properties on a message. These properties are not
				// the part of message text. These properties can be used to
				// filter the messages at receiver end.
				message.setIntProperty("count", i);
				message.setText(scanner.nextLine());
				sender.send(message);
			}

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}finally{
			scanner.close();
		}
	}
}
