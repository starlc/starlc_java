/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread.testwait; 

/**
 * 计算输出其他线程锁计算的数据  
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年4月7日 starlc      
 */
public class ThreadA  {
    
    public static void main(String[] args) { 
        ThreadB b = new ThreadB(); 
        //启动计算线程 
        b.start(); 
        //线程A拥有b对象上的锁。线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者 
        synchronized (b) { 
            try { 
                System.out.println("等待对象b完成计算。。。"); 
                //当前线程A等待 
                b.wait(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println("b对象计算的总和是：" + b.total); 
        } 
    } 
}
 