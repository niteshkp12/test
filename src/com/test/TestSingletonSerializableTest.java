package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class TestSingletonSerializable implements Serializable {
	private static final long serialVersionUID = 1L;
	private volatile static TestSingletonSerializable instance = null;

	public static TestSingletonSerializable getInstance() {
		if (instance == null) {
			instance = new TestSingletonSerializable();
		}
		return instance;
	}

	protected Object readResolve() {
		return instance;
	}

	private int i = 10;
	private transient String name = "nitesh";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "TestSingletonSerializable [i=" + i + ", name=" + name + "]";
	}

}

public class TestSingletonSerializableTest {
	static TestSingletonSerializable instanceOne = TestSingletonSerializable
			.getInstance();

	public static void main(String[] args) {
		try {
			// Serialize to a file
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
					"filename.ser"));
			out.writeObject(instanceOne);
			out.close();

			instanceOne.setI(20);
			//instanceOne.setName("Kumar");
			// Serialize to a file
			ObjectInput in = new ObjectInputStream(new FileInputStream(
					"filename.ser"));
			TestSingletonSerializable instanceTwo = (TestSingletonSerializable) in
					.readObject();
			in.close();

			System.out.println(instanceOne+""+instanceOne.hashCode());
			System.out.println(instanceTwo+""+instanceTwo.hashCode());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}