/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread.testwait; 

/**
 * 计算线程 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年4月7日 starlc      
 */
public class Calculator extends Thread {
    int total; 

    public void run() { 
            synchronized (this) { 
                    for (int i = 0; i < 101; i++) { 
                            total += i; 
                    } 
            } 
            //通知所有在此对象上等待的线程 
            notifyAll(); 
    } 
}
 