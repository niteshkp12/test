package com.test;

class Outer{
	protected class Inner{
		public void printMessage(String string) {
			System.out.println("inner.main() " + string);
		}
	}
	
	public static class StaticInner{
		private void printMsg(String msg) {
		System.out.println(msg);
		}
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		Inner inner = outer.new Inner();
		inner.printMessage("asdf");
		
		Outer.Inner i = outer.new Inner();
		i.printMessage("ds");
		
		(new StaticInner()).printMsg("F");
		
	}
}
