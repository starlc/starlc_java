/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread.testwait; 

/**
 * ����1+2+3 ... +100�ĺ� 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��4��7�� starlc      
 */
public class ThreadB extends Thread {
    int total; 

    public void run() { 
        synchronized (this) { 
            for (int i = 0; i < 101; i++) { 
                total += i; 
            } 
            //����ɼ����ˣ������ڴ˶���������ϵȴ��ĵ����̣߳��ڱ������߳�A������ 
            notify(); 
        } 
    } 
}
 