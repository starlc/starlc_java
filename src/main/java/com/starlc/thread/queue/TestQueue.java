/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author starlc
 * @since jdk1.7
 * @version V-0.1
 * @Date 2018 starlc
 */
public class TestQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue bqueue = new ArrayBlockingQueue(20);
        for (int i = 0; i < 30; i++) {
        	//将指定元素添加到此阻塞栈中，如果没有可用空间，将一直等待（如果有必要）。 
            bqueue.put(i);
            System.out.println("xxxx:" + i);
        }
        System.out.println("xxxx----");
    }
}
