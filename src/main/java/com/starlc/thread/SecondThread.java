/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread; 

import com.starlc.util.Console;

/**
 * 实现runnable接口的线程类
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年4月7日 starlc      
 */
public class SecondThread implements Runnable{
    private String name;
    
    /**
     * 构造函数
     */
    public SecondThread(String name) {
       this.name = name;
    }
    /** (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Console.log("{0}线程启动了",this.getClass().getName());
        }
    }

}
 