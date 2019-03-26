package com.starlc.thread2.runner;

/**
 * notifyAll 唤醒所有线程，但是仍然只有一个线程能够获取到锁 执行，只有当获取到锁的线程执行完成后，下一个线程才能执行。
 * 要想达到满意的效果，一个是使用circleBarrier 
 * 或者使用 多个 裁判对象
 * @author starlc
 *
 */
public class TestNotifyAll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Object judge = new Object();

		// 运动员入场
		for (int i = 0; i < 5; i++) {
			new Thread(new WorkRunner(judge)).start();
		}
		
		//裁判到场
		new Thread(new WorkJudge(judge)).start();
	}

}

class WorkRunner extends AbstractRunner implements Runnable {
	private Object obj;

	public WorkRunner(Object judge) {
		this.obj = judge;
	}

	@Override
	public void run() {
		synchronized (obj) {
			try {
				prepare();
				obj.wait();
				running();
			} catch (InterruptedException e) {
			}

		}
	}

}

class WorkJudge extends AbstractJudger implements Runnable{
	
	private Object obj;

	public WorkJudge(Object judge) {
		this.obj = judge;
	}
	@Override
	public void run() {
		judge();
		synchronized (obj) {
			obj.notifyAll();
		}
	}
	
}