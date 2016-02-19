package com.example.jms._04DurableSubscription;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class _01Publisher {
	public static void main(String[] args) {
		try {
			publishText("dynamicTopics/testDurableTopic");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void publishText(String topicName) throws JMSException {
		TopicConnection con = null;
		TopicSession session = null;
		TopicPublisher publisher = null;
		try {
			// Look for the jndi.properties file
			InitialContext context = new InitialContext();
			TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup("TopicConnectionFactory");
			Topic topic = (Topic) context.lookup(topicName);

			con = factory.createTopicConnection();
			session = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			publisher = session.createPublisher(topic);

			TextMessage message = session.createTextMessage();
			Scanner scanner = new Scanner(System.in);

			while (true) {
				message.setText(scanner.nextLine());
				publisher.publish(message);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			publisher.close();
			session.close();
			con.close();
		}
	}
}
