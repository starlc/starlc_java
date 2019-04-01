/**
 *
 */
package com.starlc.jvm.oom;

import java.util.ArrayList;

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
	
	private int stackLength = 0;
	
	/*
	 * 无限递归 让栈发生 stackOverflow Ec 线程请求深度超过虚拟机栈允许的最大深度
	 * -Xss128k
	 * 优化策略 调小虚拟机栈大小  排查代码
	 */
	public void tech(){
		stackLength++;
		tech();
	}
}
