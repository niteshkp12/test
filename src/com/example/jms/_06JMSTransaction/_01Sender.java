package com.example.jms._06JMSTransaction;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;

public class _01Sender {
	public static void main(String[] args) {
		try {
			int count = 5;
			if (args.length > 0) {
				try {
					count = Integer.parseInt(args[0]);
				} catch (Exception e) {

				}
			}
			InitialContext context = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) context
					.lookup("QueueConnectionFactory");
			Queue queue = (Queue) context.lookup("dynamicQueues/testQ");

			QueueConnection con = factory.createQueueConnection();
			QueueSession session = con.createQueueSession(true, 0);
			QueueSender sender = session.createSender(queue);

			TextMessage message = session.createTextMessage();
			Scanner scanner = new Scanner(System.in);

			try {
				for (int i = 0; i < count; i++) {
					message.setText(scanner.nextLine());
					sender.send(message);
					if (i == 5) {
						throw new NotSupportedException();
					}
				}
				session.commit();
			} catch (Exception e) {
				session.rollback();
			} finally {
				scanner.close();
				sender.close();
				session.close();
				con.close();
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
