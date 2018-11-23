/**
 * 
 */
package com.starlc.jvm.basic.number;

/**
 * @author starlc
 *
 */
public class Test {
	private int a=0xDada_Cafe;
	private float b = 0x1.fffffeP+127f;
	private float c = 1996;
	//private float d = 1996.3; cannot convert from double to float
	//private float f = 9999e2;cannot convert from double to float
	private double g = 33e2;
	private float h = 0x1.fffep-12f;
	//private float i = 1.fffep-12f;Syntax error on token "ffep
	private long p = 0b1_1_1_0_1;
	//private long q = 0b1_1_1_0_2;Underscores have to be located within digits �»��߱���λ������֮��
	
	public static void main(String[] args) {
		test2();
	}
	
	void test1(){
		Test test = new Test();
		System.out.println(test.a);
		System.out.println(test.b);
		System.out.println(test.c);
		System.out.println(test.g);
		System.out.println(test.h);
		System.out.println(test.p);
	}
	
	static void  test2(){
		int a=-6;
		// int ������32λ ��һλ�Ƿ���λ 
		for (int i = 0; i < 32; i++) {
			//0x Ϊ8���Ʊ�ʾ 0x80000000 ��32λ����ʾ ���λΪ1 �� 1000000...
			//0x800000000 ������iλ ����a���а�λ������  ������31-i λ
			int t = (a&0x80000000>>>i)>>>(31-i);
			/**
			 * ��һ������
			 * 11111111111111111111111111111010
			 * 10000000000000000000000000000000���в����� �õ����
			 * 10000000000000000000000000000000 ������31λ ��
			 * 00000000000000000000000000000001 
			 * 
			 * �ڶ�������
			 * 11111111111111111111111111111010
			 * 01000000000000000000000000000000 &���� 
			 * 01000000000000000000000000000000 ������30λ ���Ϊ
			 * 00000000000000000000000000000001 
			 */
			System.out.print(t);
		}
		System.out.println("============");
		System.out.println(1&1);
	}
}
