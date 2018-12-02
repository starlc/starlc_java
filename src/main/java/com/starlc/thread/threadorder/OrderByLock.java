/**
 * 
 */
package com.starlc.thread.threadorder;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 结果发现不行，只能保证互斥
 * @author starlc
 *
 */
public class OrderByLock {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Lock l1 = new ReentrantLock();
		
		Thread t1 = new Thread(new Work1(l1));
		Thread t2 = new Thread(new Work1(l1));
		Thread t3 = new Thread(new Work1(l1));
		
		t1.start();
		//Thread.sleep(1000);
		t2.start();
		t3.start();
	}

}

class Work1 implements Runnable{
	private Lock lock ;
	
	public Work1(Lock lock) {
		this.lock = lock;
	}
	@Override
	public void run() {
		if (lock!=null) {
			lock.lock();
			int waitTime = new Random().nextInt(2000);
			System.out.println(waitTime+" run start "+Thread.currentThread().getName());
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
			}finally{
				lock.unlock();
			}
			System.out.println(waitTime+" run end "+Thread.currentThread().getName());
		}
	}
	
}
