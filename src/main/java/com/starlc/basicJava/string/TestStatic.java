package com.starlc.basicJava.string;

/**
 * @Title: spring-framework-4.3.x
 * @Description:
 * @Author: starlc on 2019/4/19.
 * @Version: 1.0
 */
public class TestStatic {
	public static int A=0;

	public static void main(String[] args) {
		TestStatic a = new TestStatic();
		System.out.println(a.A);
		System.out.println(TestStatic.A);
	}
}
