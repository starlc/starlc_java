/**
 *
 */
package com.starlc.basicJava.classtest;

/**
 * @author starlc
 */
public class Child extends Super {

	public Child() {
		super();
		System.out.println("child construtor");
	}

	@Override
	void sayHello() {
		System.out.println("hello child");
	}


	public static void main(String[] args) {
		Super super1 = new Child();
		super1.sayHello();
	}
}
