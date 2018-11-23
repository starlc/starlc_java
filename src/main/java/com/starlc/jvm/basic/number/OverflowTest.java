/**
 * 
 */
package com.starlc.jvm.basic.number;

/**
 * @author starlc
 *
 */
public class OverflowTest {

	private volatile int i=0;
	private volatile int b=0;
	private volatile int c=0;
	
//	private  int i=0;
//	private  int b=0;
//	private  int c=0;
	
	public static void main(String[] args) {
		OverflowTest o=new OverflowTest();
		try {
			o.deepTest();
		} catch (Throwable e) {
			System.out.println("over flow deep:"+o.i);
			e.printStackTrace();
		}
	}
	private void deepTest() {
		++i;
		++b;
		++c;
		deepTest();
	}

}
