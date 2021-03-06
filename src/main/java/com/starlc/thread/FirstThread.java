/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread; 

import com.starlc.util.Console;

/**
 * 线程实现类
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年4月7日 starlc      
 */
public class FirstThread extends Thread {
    /**
     * 构造函数
     */
    public FirstThread(String name) {
        super(name);
        System.out.println("实例化当前对象");
    }
    /** (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Console.log("{0}线程启动了{1}",this.getClass().getName(),this.getName());
        }
    }
}
 