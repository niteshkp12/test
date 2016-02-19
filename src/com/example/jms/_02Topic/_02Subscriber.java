package com.example.jms._02Topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSubscriber;
import javax.jms.TopicSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class _02Subscriber {
	public static void main(String[] args) {
		try {
			readTextTopic("dynamicTopics/testT");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readTextTopic(String topicName) throws JMSException {
		TopicConnection con = null;
		TopicSession session = null;
		TopicSubscriber subscriber = null;
		try {
			InitialContext context = new InitialContext();
			TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup("TopicConnectionFactory");
			Topic topic = (Topic) context.lookup(topicName);

			con = factory.createTopicConnection();
			session = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			subscriber = session.createSubscriber(topic);

			con.start();

			while (true) {
				Message message = subscriber.receive();
				TextMessage textMessage = (TextMessage) message;
				System.out.println(textMessage.getText());
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			subscriber.close();
			session.close();
			con.close();
		}
	}
}