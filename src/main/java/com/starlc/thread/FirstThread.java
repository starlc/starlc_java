/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread; 

import com.starlc.util.Console;

/**
 * �߳�ʵ����
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��4��7�� starlc      
 */
public class FirstThread extends Thread {
    /**
     * ���캯��
     */
    public FirstThread(String name) {
        super(name);
        System.out.println("ʵ������ǰ����");
    }
    /** (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Console.log("{0}�߳�������{1}",this.getClass().getName(),this.getName());
        }
    }
}
 