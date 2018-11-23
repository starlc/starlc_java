/**
 *
 */
package com.starlc.basicJava.string;

/**
 * @author starlc
 *
 */
public class StringTest {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
	/**
	 * new 方法会在heap创建一个对象 ，其引用指向字符串常量池
	 */
	public static void test1() {
		String t1 = "abcd";
		String t2 = new String("abcd");
		String t3 = t2.intern();
		System.out.println(t1==t2);
		System.out.println(t1==t3);
		System.out.println(t2==t3);
		System.out.println(t1.equals(t2));
	}

	public static final String A; // 常量A
	public static final String B;    // 常量B
	static {
		A = "ab";
		B = "cd";
	}
	public static void test2(){
		// 将两个常量用+连接对s进行初始化
		String s = A + B;
		String t = "abcd";
		if (s == t) {
			System.out.println("s等于t，它们是同一个对象");
		} else {
			System.out.println("s不等于t，它们不是同一个对象");
		}
	}

	public static final String C = "ab"; // 常量A
	public static final String D = "cd"; // 常量B
	public static void test3() {
		String s = C + D;  // 将两个常量用+连接对s进行初始化
		String t = "abcd";
		if (s == t) {
			System.out.println("s等于t，它们是同一个对象");
		} else {
			System.out.println("s不等于t，它们不是同一个对象");
		}
	}
}
