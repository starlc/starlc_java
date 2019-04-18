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

	/**
	 * 这个要怎么解释
	 * 当String作为形参传递到方法里的时候,实际上传递的是str引用的拷贝,改变的是str引用的拷贝,而后方法结束
	 * ，形参str被销毁, 原str的引用保持不变,还是指向原常量池中的abc  这个方法输出的是abc
	 * @param text
	 */
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
