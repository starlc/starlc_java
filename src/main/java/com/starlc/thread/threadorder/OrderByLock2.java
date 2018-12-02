/**
 * 
 */
package com.starlc.thread.threadorder;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 也不行 T2一定会先于T1执行
 * @author starlc
 *
 */
public class OrderByLock2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lock l0 = new ReentrantLock();
		Lock l1 = new ReentrantLock();
		Lock l2 = new ReentrantLock();
		
		Thread t1 = new Thread(new Work2(l0,l1));
		Thread t2 = new Thread(new Work2(l1,l2));
		Thread t3 = new Thread(new Work2(l2,null));
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class Work2 implements Runnable{
	private Lock block ;
	private Lock clock ;
	
	public Work2(Lock block,Lock cLock) {
		this.block = block;
		this.clock = cLock;
	}
	@Override
	public void run() {
		if (block!=null) {
			block.lock();
			if(clock!=null)clock.lock();
			int waitTime = new Random().nextInt(2000);
			System.out.println(waitTime+" run "+Thread.currentThread().getName());
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
			}finally{
				block.unlock();
				if(clock!=null)clock.unlock();
			}
			System.out.println(waitTime+" end "+Thread.currentThread().getName());
		}
	}
	
}
