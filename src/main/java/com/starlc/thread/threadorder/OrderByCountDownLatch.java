/**
 *
 */
package com.starlc.thread.threadorder;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author starlc
 */
public class OrderByCountDownLatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch c0 = new CountDownLatch(0);
		CountDownLatch c1 = new CountDownLatch(1);
		CountDownLatch c2 = new CountDownLatch(1);

		Thread t1 = new Thread(new Work(c0, c1));
		Thread t2 = new Thread(new Work(c1, c2));
		Thread t3 = new Thread(new Work(c2, c2));

		t1.start();
		t2.start();
		t3.start();

	}

}

class Work implements Runnable {
	CountDownLatch before;

	CountDownLatch current;

	public Work(CountDownLatch before, CountDownLatch current) {
		super();
		this.before = before;
		this.current = current;
	}

	@Override
	public void run() {
		int waitTime = new Random().nextInt(2000);
		try {
			before.await();
			System.out.println(waitTime + " run start " + Thread.currentThread().getName());
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
		} finally {
			current.countDown();

		}
		System.out.println(waitTime + " run end " + Thread.currentThread().getName());
	}

}
