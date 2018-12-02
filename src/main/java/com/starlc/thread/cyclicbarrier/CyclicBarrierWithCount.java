package com.starlc.thread.cyclicbarrier;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class CyclicBarrierWithCount {
	private final static CountDownLatch cdl=new CountDownLatch(3);
	private final static ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());//使用线程池
	
	private static class GoThread extends Thread{
		private final String name;
		
		public GoThread(String name)
		{
			this.name=name;
			
		}
		public void run()
		{
			System.out.println(name+"开始从宿舍出发");
			cdl.countDown();
			try
			{
				Thread.sleep(1000);
				cdl.await();//拦截线程
				System.out.println(name+"从楼底下出发");
				Thread.sleep(1000);
				System.out.println(name+"到达操场");
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
 
			
			
		}
	}
	
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[] str= {"李明","王强","刘凯","赵杰"};
		String[] str1= {"王二","洪光","雷兵","赵三"};
		for(int i=0;i<4;i++)
		{
			threadPool.execute(new GoThread(str[i]));
		}
		try
		{
			Thread.sleep(4000);
			System.out.println("四个人一起到达球场，现在开始打球");
			System.out.println("现在对CyclicBarrier进行复用.....");
			System.out.println("又来了一拨人，看看愿不愿意一起打：");
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		for(int i=0;i<4;i++)
		{
			threadPool.execute(new GoThread(str1[i]));
		}
		try
		{
			Thread.sleep(4000);
			System.out.println("四个人一起到达球场，表示愿意一起打球，现在八个人开始打球");
			//System.out.println("现在对CyclicBarrier进行复用");
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
 
}
