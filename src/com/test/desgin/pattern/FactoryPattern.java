package com.test.desgin.pattern;

interface Logger {
	public void log(String message);
}

class XMLLogger implements Logger {

	@Override
	public void log(String message) {
		System.err.println(message);
	}
}

abstract class AbstractLoggerCreater {
	public abstract Logger createLogger();
}

class XMLLoggerCreate extends AbstractLoggerCreater {

	@Override
	public Logger createLogger() {
		XMLLogger logger = new XMLLogger();
		return logger;
	}
}

class Client{
	public void logSomeThing(AbstractLoggerCreater loggerCreater) {
		Logger logger = loggerCreater.createLogger();
		logger.log("Logges message");
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		AbstractLoggerCreater loggerCreater = new XMLLoggerCreate();
		Client client = new Client();
		client.logSomeThing(loggerCreater);
	}
}
