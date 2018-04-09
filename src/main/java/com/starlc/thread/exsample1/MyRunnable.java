/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread.exsample1; 

import com.starlc.util.Console;

/**
 * ��ע����Ϣ
 * @Description:   TODO(��һ�仰�������ļ���ʲô) 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��4��7�� starlc      
 */
public class MyRunnable implements Runnable {

    private Foo foo = new Foo(); 

    public static void main(String[] args) { 
        MyRunnable r = new MyRunnable(); 
        Thread ta = new Thread(r, "Thread-A"); 
        Thread tb = new Thread(r, "Thread-B"); 
        ta.start(); 
        tb.start(); 
    } 
    
    @Override
    public void run() { 
        for (int i = 0; i < 3; i++) { 
            this.fix(30); 
            Console.log("˯��ǰ{0} : ��ǰfoo�����xֵ= {1}",Thread.currentThread().getName(), foo.getX());
            try { 
                Thread.sleep(1); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            Console.log("{0} : ��ǰfoo�����xֵ= {1}",Thread.currentThread().getName(), foo.getX());
        } 
    } 

    public int fix(int y) { 
        return foo.fix1(y); 
    } 

}
 