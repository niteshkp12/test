package com.nitesh.rabbitmq.workQueue;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {

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
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		/*
		 * This tells RabbitMQ not to give more than one message to a worker at
		 * a time. Or, in other words, don't dispatch a new message to a worker
		 * until it has processed and acknowledged the previous one.
		 */
		int prefetchCount = 1;
		channel.basicQos(prefetchCount);

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, false, consumer);
		/*
		 * true will set auto acknowledgement on by default its true
		 */

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.err.println("Worker is going to fetch message.....");
			Thread.sleep(5000);
			System.out.println(" [x] Received '" + message + "'");
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
			System.err.println("Message fetched");
		}
	}
}