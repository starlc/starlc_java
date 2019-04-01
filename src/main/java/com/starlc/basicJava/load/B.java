/**
 * 
 */
package com.starlc.basicJava.load;

/**
 * @author starlc
 *
 */
public class B extends A{
	
	static{
		System.out.println("B1");
	}
	@Override
	void pay() {
		super.pay();
		System.out.println("B2");
	}
	
	public static void main(String[] args) {
		A a = new B();
		a.pay();
		new B();
	}
}
