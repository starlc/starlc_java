/**
 * 
 */
package com.starlc.thread2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author starlc
 *ReentrantLock 的可重入
 * 
 *jps 命令
 *jstack pid 查看
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
				//lock.unlock();如果加锁俩次，释放2次
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
