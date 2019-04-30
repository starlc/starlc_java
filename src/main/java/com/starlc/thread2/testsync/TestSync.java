package com.starlc.thread2.testsync;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSync {
	public static AtomicInteger times = new AtomicInteger();
	private final static Map<String, A> map = new HashMap<String, A>();
	private final static Lock lock = new ReentrantLock();
	public static void main(String[] args) throws InterruptedException {
		int cap = 100000; //1000
		final CountDownLatch latch = new CountDownLatch(cap);
		final CountDownLatch latch2 = new CountDownLatch(cap);
		final long start = System.nanoTime();
		//final List<Long> lst = new ArrayList<Long>();
		for (int i = 0; i < cap; i++) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					//取得A对象
					//latch.countDown();
					//Test().sayHello();;
					//test2().sayHello();//6047393ms		145849098ms/131350569ms
					test3().sayHello();//6043196ms  		 78953274ms/113151259ms
					//test4().sayHello();//错误写法
					//test5().sayHello();//6036100ms  		112810473ms/101512453ms
					//test6().sayHello();//6039701ms  		116672363ms/125889330ms			5和6 锁哪个对象比较好呢
					//test7().sayHello();//错误写法
					//test8().sayHello();//错误写法
					//test9().sayHello();//错误写法
					//test10().sayHello();//错误写法
					//test11().sayHello();//6083141ms		144232565ms/136989338ms
					//test12().sayHello();//				136347294ms/138648574ms
					
					//System.out.println(Thread.currentThread().getName()+"耗时："+(System.nanoTime()-start)/1000+"ms");
					//lst.add((System.nanoTime()-start)/1000);
					latch2.countDown();
					
				}
			});
			t.start();
			//latch.countDown();
		}
		latch2.await();
		System.out.println("耗时："+(System.nanoTime()-start)/1000+"ms");
		
	}
	
	//测试
	static A Test(){
		//Map<String, A> map = new HashMap<String, A>();
		A a = map.get("a");
		if (a == null) {
			a = new A();
			map.put("a", a);
		}
		return a;
	}
	
	static synchronized A test2(){
		A a = map.get("a");
		if (a == null) {
			a = new A();
			map.put("a", a);
		}
		return a;
	}
	
	static  A test3(){
		synchronized (TestSync.class) {
			A a = map.get("a");
			if (a == null) {
				a = new A();
			}
			map.put("a", a);
			return a;
		}
	}
	
	static  A test4(){
		A a = null;
		synchronized (map) {
			a = map.get("a");
			if (a == null) {
				a = new A();
			}
		}
		map.put("a", a);
		return a;
	}
	
	static  A test5(){
		A a = null;
		synchronized (map) {
			a = map.get("a");
			if (a == null) {
				a = new A();
				map.put("a", a);
			}
		}
		return a;
	}
	
	static  A test6(){
		A a = null;
		synchronized (TestSync.class) {
			a = map.get("a");
			if (a == null) {
				a = new A();
				map.put("a", a);
			}
		}
		return a;
	}
	
	static  A test7(){
		A a = map.get("a");
		synchronized (TestSync.class) {
			if (a == null) {
				a = new A();
				map.put("a", a);
			}
		}
		return a;
	}
	
	static A test8() {
		A a = map.get("a");
		if (a == null) {
			synchronized (TestSync.class) {
				a = new A();
				map.put("a", a);
			}
		}
		return a;
	}
	
	static A test9() {
		A a = map.get("a");
		if (a == null) {
			synchronized (TestSync.class) {
				if (a==null) {
					a = new A();
					map.put("a", a);
				}
			}
		}
		return a;
	}
	
	static A test10() {
		A a = map.get("a");
		if (a == null) {
			synchronized (TestSync.class) {
				A b = a;
				if (b == null) {
					synchronized (TestSync.class) {
						b = new A();
						map.put("a", b);
					}
					a = b;
				}
			}
		}
		return a;
	}
	
	static A test11() {

		lock.lock();
		A a = null;
		a = map.get("a");
		if (a == null) {
			a = new A();
			map.put("a", a);
		}
		lock.unlock();
		return a;
	}
	
	static A test12() {
		lock.lock();
		A a = map.get("a");
		lock.unlock();
		if (a == null) {
			lock.lock();
			a = map.get("a");
			if (a == null) {
				a = new A();
				map.put("a", a);
			}
			lock.unlock();
		}
		return a;
	}
}

class A{
	public A() {
		try {
			//模拟 假设A的创建需要很长时间 
			Thread.sleep(3000);
			//TestSync.times.incrementAndGet();
			System.out.println("A对象创建好了");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void sayHello(){
		//System.out.println("hello");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}