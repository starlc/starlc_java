/**
 *
 */
package com.starlc.jvm.oom;

/**
 * @author starlc
 *
 */
public class TestStackOOM implements Runnable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	/**
	 * -Xmx1g -Xss10m
	 * 减少堆空间
	 * 减少线程栈大小
	 */
	static void test(){
		for (int i = 0; i < 10000; i++) {
			new Thread(new TestStackOOM(),"Thread"+i).start();
			System.out.println("Thread"+i+" is created");
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100000000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
