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
	 * new ��������heap����һ������ ��������ָ���ַ���������
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
	
	public static final String A; // ����A
	public static final String B;    // ����B
	static {   
	     A = "ab";   
	     B = "cd";   
	 } 
	public static void test2(){
		// ������������+���Ӷ�s���г�ʼ��   
	     String s = A + B;   
	     String t = "abcd";   
	    if (s == t) {   
	         System.out.println("s����t��������ͬһ������");   
	     } else {   
	         System.out.println("s������t�����ǲ���ͬһ������");   
	     }
	}
	
	public static final String C = "ab"; // ����A
	public static final String D = "cd"; // ����B
	public static void test3() {
	     String s = C + D;  // ������������+���Ӷ�s���г�ʼ�� 
	     String t = "abcd";   
	    if (s == t) {   
	         System.out.println("s����t��������ͬһ������");   
	     } else {   
	         System.out.println("s������t�����ǲ���ͬһ������");   
	     }   
	 }
}
