/**
 * 
 */
package com.starlc.thread2.runner;

/**
 * @author starlc
 *
 */
public abstract class AbstractRunner implements Runner {

	@Override
	public void running() {
		try {
			System.out.println("运动员"+Thread.currentThread().getId()+"开跑");
			long time = (long)(Math.random()*1000);
			Thread.sleep(time);
			System.out.println("运动员"+Thread.currentThread().getId()+"跑步结束,用时"+time);
		} catch (InterruptedException e) {
		}

	}
	
	@Override
	public void prepare() {
		try {
			long time = (long)(Math.random()*1000);
			Thread.sleep(time);
			System.out.println("运动员"+Thread.currentThread().getId()+"完成准备");
		} catch (InterruptedException e) {
		}
	}
}
