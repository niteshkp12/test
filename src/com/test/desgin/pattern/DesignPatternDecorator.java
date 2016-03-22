
package com.test.desgin.pattern;

interface Icecream {
	String makeIcecream();
}

abstract class IcecreamDecorator implements Icecream{
	
	protected Icecream icecream;
	
	public IcecreamDecorator(Icecream icecream) {
		super();
		this.icecream = icecream;
	}

	@Override
	public String makeIcecream() {
		return icecream.makeIcecream();
	}
}

class SimpleIcecream implements Icecream{
	@Override
	public String makeIcecream() {
		return "SimpleIcecream";
	}
}

class NutsDecorator extends IcecreamDecorator{
	
	
	public NutsDecorator(Icecream icecream) {
		super(icecream);
	}
	
	@Override
	public String makeIcecream() {
		return icecream.makeIcecream() + addNuts();
	}

	private String addNuts() {
		return " + nuts";
	}
}

class HoneyDecorator extends IcecreamDecorator{

	public HoneyDecorator(Icecream icecream) {
		super(icecream);
	}
	
	@Override
	public String makeIcecream() {
		return icecream.makeIcecream() + addHoney();
	}

	private String addHoney() {
		return " + Honey";
	}
	
}

public class DesignPatternDecorator {

	public static void main(String[] args) {
		System.out.println("DesignPatternDecorator.main()");
		Icecream icecream = new HoneyDecorator(new NutsDecorator(new SimpleIcecream()));
		System.out.println(icecream.makeIcecream());
	}

}
