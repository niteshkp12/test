package com.nitesh.rabbitmq.workQueue;

import java.util.Scanner;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

public class Send {

	private final static String QUEUE_NAME = "WorkQueue";

	public static void main(String[] argv) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		/*
		 * In order to make sure that RabbitMQ will never lose our queue, we
		 * need to declare it as durable.
		 */
		boolean durable = true;
		channel.queueDeclare(QUEUE_NAME, durable, false, false, null);

		boolean status = true;
		while (status) {
			Scanner scanner = new Scanner(System.in);
			String message = scanner.next();
			System.err.println("[x] Sent '" + message + "'");

			/*
			 * It marks our messages as persistent - by setting
			 * MessageProperties (which implements BasicProperties) to the value
			 * PERSISTENT_TEXT_PLAIN.
			 * 
			 * {Marking messages as persistent doesn't fully guarantee that a
			 * message won't be lost. Although it tells RabbitMQ to save the
			 * message to disk, there is still a short time window when RabbitMQ
			 * has accepted a message and hasn't saved it yet.}
			 */
			channel.basicPublish("", QUEUE_NAME,
					MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());

		}
		channel.close();
		connection.close();
	}
}