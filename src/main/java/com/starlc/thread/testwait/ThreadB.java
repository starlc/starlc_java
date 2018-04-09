/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread.testwait; 

/**
 * 计算1+2+3 ... +100的和 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年4月7日 starlc      
 */
public class ThreadB extends Thread {
    int total; 

    public void run() { 
        synchronized (this) { 
            for (int i = 0; i < 101; i++) { 
                total += i; 
            } 
            //（完成计算了）唤醒在此对象监视器上等待的单个线程，在本例中线程A被唤醒 
            notify(); 
        } 
    } 
}
 