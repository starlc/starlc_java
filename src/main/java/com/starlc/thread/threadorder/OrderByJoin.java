/**
 * 
 */
package com.starlc.thread.threadorder;

import java.util.Random;

/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 * 
 * 使用join 加入到线程中 有问题  只能保证T1比T2先执行完 T2比T3先执行完
 * @author starlc
 *
 */
public class OrderByJoin {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//test1(); 失败 无法保证顺序
		//test2();
		test3();
	}
	
	static void test1(){
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("run "+Thread.currentThread().getName());
				}
			},"Thread-"+i);
			t.start();
		}
	}
	
	/**
	 * 虽然保证了执行顺序，但是这种在run方法内部添加join方法是十分不可取的。
	 * @throws InterruptedException
	 */
	static void test2()throws InterruptedException{
		final Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int waitTime = new Random().nextInt(2000);
				System.out.println(waitTime+" start "+Thread.currentThread().getName());
				try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e) {
				}
				System.out.println(waitTime+" run "+Thread.currentThread().getName());
			}
		},"T1");
		
		final Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int waitTime = new Random().nextInt(2000);
				System.out.println(waitTime+" start "+Thread.currentThread().getName());
				try {
					Thread.sleep(waitTime);
					t1.join();
				} catch (InterruptedException e) {
				}
				System.out.println(waitTime+" run "+Thread.currentThread().getName());
			}
		},"T2");

		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int waitTime = new Random().nextInt(2000);
				System.out.println(waitTime+" start "+Thread.currentThread().getName());
				try {
					Thread.sleep(waitTime);
					t2.join();
				} catch (InterruptedException e) {
				}
				System.out.println(waitTime+" run  "+Thread.currentThread().getName());
			}
		},"T3");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
	}
	
	
	static void test3()throws InterruptedException{
		Thread t1 = new Order(null,"T11");
		Thread t2 = new Order(t1,"T22");
		Thread t3 = new Order(t2,"T33");
		
		t1.start();
		//Thread.sleep(1000);//不能保证顺序
		t2.start();
		t3.start();
	}
}
class Order extends Thread{
	private Thread beforeThread;
	public Order(Thread beforeThread,String name) {
		super(name);
		this.beforeThread = beforeThread;
	}
	@Override
	public void run() {
		try {
			if (beforeThread!=null) {
				beforeThread.join();
			}
			System.out.println("start "+Thread.currentThread().getName());
			Thread.sleep(new Random().nextInt(2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end "+Thread.currentThread().getName());
	}
	
}