package com.nitesh.rabbitmq.routing;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

public class ReceiveLogsDirect {

	private static final String EXCHANGE_NAME = "direct_logs_exchange";
	private final static String QUEUE_NAME = "routingQueue";

	public static void main(String[] argv) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		
		/* server generate queuename */
		// String queueName = channel.queueDeclare().getQueue();

		String[] severity = new String[] { "error", "info", "warning" };

		for (String s : severity) {
			channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, s);
		}

		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			String routingKey = delivery.getEnvelope().getRoutingKey();

			System.err.println("Worker is going to fetch message.....");
			Thread.sleep(5000);
			System.out.println(" [x] Received '" + routingKey + "':'" + message
					+ "'");
			System.err.println("Message fetched");
		}
	}
}
