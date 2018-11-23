/**
 *
 */
package com.starlc.basicJava.value;

/**
 * 值传递还是引用传递
 * @author starlc
 *
 */
public class Basic {

	public static void main(String[] args) {
		Basic basic = new Basic();
		int num = 1;
		basic.foo(num);
		System.out.println(num);

		//
		String str = "abc";
		basic.foo(str);
		System.out.println(str);

		//
		StringBuilder strB = new StringBuilder("iphone");
		basic.foo(strB);
		System.out.println(strB);

		StringBuilder strC = new StringBuilder("iphone");
		basic.fooStringBuilder(strC);
		System.out.println(strC);
	}
	void foo(int value) {
		value = 100;
	}
	void foo(String text) {
		text = "windows";
	}

	void foo(StringBuilder builder) {
		builder.append("4");
	}

	void fooStringBuilder(StringBuilder builder) {
		builder = new StringBuilder("ipad");
	}
}
