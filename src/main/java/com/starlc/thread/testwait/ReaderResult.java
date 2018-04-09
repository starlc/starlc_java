/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread.testwait; 

/**
 * ��ȡ����������� 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��4��7�� starlc      
 */
public class ReaderResult extends Thread {
    Calculator c; 

    public ReaderResult(Calculator c) { 
            this.c = c; 
    } 

    public void run() { 
            synchronized (c) { 
                    try { 
                            System.out.println(Thread.currentThread() + "�ȴ�������������"); 
                            c.wait(); 
                    } catch (InterruptedException e) { 
                            e.printStackTrace(); 
                    } 
                    System.out.println(Thread.currentThread() + "������Ϊ��" + c.total); 
            } 
    } 

    public static void main(String[] args) { 
            Calculator calculator = new Calculator(); 

            //���������̣߳��ֱ��ȡ������ 
            new ReaderResult(calculator).start(); 
            new ReaderResult(calculator).start(); 
            new ReaderResult(calculator).start(); 
            //���������߳� 
            calculator.start(); 
    } 
}
 