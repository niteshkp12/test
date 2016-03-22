package com.test;

import java.io.Closeable;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

enum ThreadStates {
	START, RUNNING, WAITING, DEAD;
}

/**
 * This Enum example shows all the things we can do with Enum types
 * 
 * @author pankaj
 * 
 */
enum ThreadStatesEnum implements Closeable {
	START(1) {
		@Override
		public String toString() {
			return "START implementation. Priority=" + getPriority();
		}

		@Override
		public String getDetail() {
			return "START";
		}
	},
	RUNNING(2) {
		@Override
		public String getDetail() {
			return "RUNNING";
		}
	},
	WAITING(3) {
		@Override
		public String getDetail() {
			return "WAITING";
		}
	},
	DEAD(4) {
		@Override
		public String getDetail() {
			return "DEAD";
		}
	};

	private int priority;

	public abstract String getDetail();

	// Enum constructors should always be private.
	private ThreadStatesEnum(int i) {
		priority = i;
	}

	// Enum can have methods
	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int p) {
		this.priority = p;
	}

	// Enum can override functions
	@Override
	public String toString() {
		return "Default ThreadStatesConstructors implementation. Priority="
				+ getPriority();
	}

	@Override
	public void close() throws IOException {
		System.out.println("Close of Enum");
	}
}

public class TestEnum {
	public static void main(String[] args) throws IOException {
		System.out.println("TestTest.main()");
		
		String s = "START";
		
		ThreadStates states = ThreadStates.valueOf(s.toString());
		
		usingEnumMethods();
		usingEnumValueOf();
		usingEnumValues();
		usingEnumInSwitch(ThreadStatesEnum.START);
		usingEnumInSwitch(ThreadStatesEnum.DEAD);
		usingEnumMap();
		usingEnumSet();
	}

	private static void usingEnumSet() {
		EnumSet<ThreadStatesEnum> enumSet = EnumSet
				.allOf(ThreadStatesEnum.class);
		for (ThreadStatesEnum tsenum : enumSet) {
			System.out.println("Using EnumSet, priority = "
					+ tsenum.getPriority());
		}
	}

	private static void usingEnumMap() {
		EnumMap<ThreadStates, String> enumMap = new EnumMap<ThreadStates, String>(
				ThreadStates.class);
		enumMap.put(ThreadStates.START, "Thread is started");
		enumMap.put(ThreadStates.RUNNING, "Thread is running");
		enumMap.put(ThreadStates.WAITING, "Thread is waiting");
		enumMap.put(ThreadStates.DEAD, "Thread is dead");

		Set<ThreadStates> keySet = enumMap.keySet();
		for (ThreadStates key : keySet) {
			System.out.println("key=" + key.toString() + ":: value="
					+ enumMap.get(key));
		}

	}

	private static void usingEnumInSwitch(ThreadStatesEnum th) {
		switch (th) {
		case START:
			System.out.println("START thread");
			break;
		case WAITING:
			System.out.println("WAITING thread");
			break;
		case RUNNING:
			System.out.println("RUNNING thread");
			break;
		case DEAD:
			System.out.println("DEAD thread");
		}
	}

	private static void usingEnumValues() {
		ThreadStatesEnum[] thArray = ThreadStatesEnum.values();

		for (ThreadStatesEnum th : thArray) {
			System.out
					.println(th.toString() + "::priority=" + th.getPriority());
		}
	}

	private static void usingEnumValueOf() {
		ThreadStatesEnum th = Enum.valueOf(ThreadStatesEnum.class, "START");
		System.out.println("th priority=" + th.getPriority());
	}

	private static void usingEnumMethods() throws IOException {
		ThreadStatesEnum thc = ThreadStatesEnum.DEAD;
		System.out.println("priority is:" + thc.getPriority());

		thc = ThreadStatesEnum.DEAD;
		System.out.println("Using overriden method." + thc.toString());

		thc = ThreadStatesEnum.START;
		System.out.println("Using overriden method." + thc.toString());
		thc.setPriority(10);
		System.out.println("Enum Constant variable changed priority value="
				+ thc.getPriority());
		thc.close();
	}

}