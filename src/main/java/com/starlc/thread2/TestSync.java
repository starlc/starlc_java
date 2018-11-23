/**
 * 
 */
package com.starlc.thread2;

/**
 * @author starlc
 *
 */
public class TestSync {

	
	public void sync(){
		synchronized (TestSync.class) {
			System.out.println("123");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestSync().sync();
	}
	

}
