/**
 * 
 */
package com.starlc.thread.threadorder;

import java.util.Random;

/**
 * 这种方式其实和锁是一样的道理，还是不能保证一定顺序执行。
 * @author starlc
 *
 */
public class OrderByWait {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Object object = new Object();
		Thread t1 = new Thread(new Worker(object));
		Thread t2 = new Thread(new Worker(object));
		Thread t3 = new Thread(new Worker(object));
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
		t3.start();
	}

}


class Worker implements Runnable{
	private Object obj;
	public Worker(Object obj) {
		this.obj = obj;
	}
	@Override
	public void run() {
		synchronized (obj) {
			int waitTime = new Random().nextInt(2000);
			System.out.println(waitTime+" run start"+Thread.currentThread().getName());
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
			}
			System.out.println(waitTime+" run end"+Thread.currentThread().getName());
		}
	}
	
}