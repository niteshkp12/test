package com.example.jms._04DurableSubscription;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;

public class _04DuplicateSubscriber {
	public static void main(String[] args) {
		try {
			readTextTopic("dynamicTopics/testDurableTopic");
		} catch (Exception e) {
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
			con.setClientID("testClient");
			session = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			subscriber = session.createDurableSubscriber(topic, "testSubscriber");

			con.start();

			while (true) {
				Message message = subscriber.receive();
				TextMessage textMessage = (TextMessage) message;
				System.out.println(textMessage.getText());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			subscriber.close();
			session.unsubscribe("tests");
			session.close();
			con.close();
		}
	}
}