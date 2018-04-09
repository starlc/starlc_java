/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread.testwait; 

/**
 * ������������߳������������  
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��4��7�� starlc      
 */
public class ThreadA  {
    
    public static void main(String[] args) { 
        ThreadB b = new ThreadB(); 
        //���������߳� 
        b.start(); 
        //�߳�Aӵ��b�����ϵ������߳�Ϊ�˵���wait()��notify()���������̱߳������Ǹ���������ӵ���� 
        synchronized (b) { 
            try { 
                System.out.println("�ȴ�����b��ɼ��㡣����"); 
                //��ǰ�߳�A�ȴ� 
                b.wait(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println("b���������ܺ��ǣ�" + b.total); 
        } 
    } 
}
 