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
	//private long q = 0b1_1_1_0_2;Underscores have to be located within digits 下划线必须位于数字之内
	
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
		// int 类型是32位 第一位是符号位 
		for (int i = 0; i < 32; i++) {
			//0x 为8进制表示 0x80000000 是32位数表示 最高位为1 即 1000000...
			//0x800000000 先右移i位 再与a进行按位并操作  再右移31-i 位
			int t = (a&0x80000000>>>i)>>>(31-i);
			/**
			 * 第一次运算
			 * 11111111111111111111111111111010
			 * 10000000000000000000000000000000进行并运算 得到结果
			 * 10000000000000000000000000000000 再右移31位 即
			 * 00000000000000000000000000000001 
			 * 
			 * 第二次运算
			 * 11111111111111111111111111111010
			 * 01000000000000000000000000000000 &操作 
			 * 01000000000000000000000000000000 再右移30位 结果为
			 * 00000000000000000000000000000001 
			 */
			System.out.print(t);
		}
		System.out.println("============");
		System.out.println(1&1);
	}
}
