package com.test;

class Singleton{
	public static final Singleton singleton = new Singleton();
	private Singleton(){
		
	}
	public static Singleton getInstance() {
		return singleton;
	}
	
	public void Method() {
		System.out.println("Singleton Method");
	}
	
}


class LazySingleton{
	public volatile LazySingleton lazySingleton = null;

	public LazySingleton() {
	}
	
	public LazySingleton getInstance() {
		if(lazySingleton == null)
		synchronized (LazySingleton.class) {
			if(lazySingleton == null){
				lazySingleton = new LazySingleton();
			}
		}
		return lazySingleton;
	}
}
public class TestSingleton {

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton.Method();
		
	}

}


enum enumSingleton{
	INSTANCE;
}

