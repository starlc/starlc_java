/**
 * 
 */
package com.starlc.thread2.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author starlc
 *ReentrantLock 
 * 
 *jps 
 *jstack pid 
 */
public class ReenterLock implements Runnable {
	
	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int j = 0; j < 100000; j++) {
			lock.lock();
			//lock.lock();
			try{
				i++;
			}finally{
				lock.unlock();
				//lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReenterLock lock = new ReenterLock();
		Thread t1 = new Thread(lock);
		Thread t2 = new Thread(lock);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
