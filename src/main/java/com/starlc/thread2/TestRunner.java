package com.starlc.thread2;

/**
 * 测试 wait和notifyAll();
 * 结果不符合预期，我想要的结果是 运动员先一起开跑，然后各跑各的，最后结束。
 * @author starlc
 *
 */
public class TestRunner {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Object judge = new Object();
		
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					synchronized (judge) {
						try {
							Thread.sleep((long)(Math.random()*1000));
							System.out.println("运动员"+Thread.currentThread().getId()+"到场准备");
							judge.wait();
							System.out.println("运动员"+Thread.currentThread().getId()+"开跑");
							long time = (long)(Math.random()*1000);
							Thread.sleep(time);
							System.out.println("运动员"+Thread.currentThread().getId()+"跑步结束,用时"+time);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			}
					).start();;
		}
		Thread.sleep(5000);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (judge) {
					System.out.println("开跑令响");
					judge.notifyAll();
				}
			}
		}).start();
		System.out.println("主线程结束");
	}
	
}
