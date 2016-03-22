package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSingletonSerializables implements Serializable{
	private static final long serialVersionUID = 1L;
	private volatile static TestSingletonSerializables instance = null;

	public static TestSingletonSerializables getInstance() {
		if (instance == null) {
			instance = new TestSingletonSerializables();
		}
		return instance;
	}

//	protected Object readResolve() {
//		return instance;
//	}

	private int i = 10;
	private transient String password = "nitesh";

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "i = " + i + ", password: " + password;
	}

}

class SerializationTest {
	static TestSingletonSerializables instanceOne = TestSingletonSerializables
			.getInstance();

	public static void main(String[] args) {
		try {
			// Serialize to a file
			System.out.println("SerializationTest.main()");
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
					"filename.ser"));
			out.writeObject(instanceOne);
			System.err.println(instanceOne.toString());
			out.close();

			instanceOne.setI(20);

			// Serialize to a file
			ObjectInput in = new ObjectInputStream(new FileInputStream(
					"filename.ser"));
			TestSingletonSerializables instanceTwo = (TestSingletonSerializables) in
					.readObject();
			in.close();

			System.out.println(instanceOne.toString());
			System.out.println(instanceTwo.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}