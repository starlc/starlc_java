/**
 * 
 */
package com.starlc.thread2.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 用ReenterLock构造死锁
 * @author starlc
 *
 */
public class ReenterLockInt implements Runnable {
	
	private int lock ;
	
	public static ReentrantLock lock1 = new ReentrantLock();
	
	public static ReentrantLock lock2 = new ReentrantLock();
	
	public ReenterLockInt(int lock) {
		this.lock = lock;
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ReenterLockInt t1 = new ReenterLockInt(1);
		ReenterLockInt t2 = new ReenterLockInt(2);
		Thread thread1 = new Thread(t1);
		thread1.start();
		Thread thread2 = new Thread(t2);
		thread2.start();
		
		thread1.join();
		thread2.join();
	}
	
	
	@Override
	public void run() {
		try {
			if (lock==1) {
				lock1.lockInterruptibly();
				Thread.sleep(1000);
				lock2.lockInterruptibly();
			}else {
				lock2.lockInterruptibly();
				Thread.sleep(1000);
				lock1.lockInterruptibly();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if (lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
		}
		
	}

}
