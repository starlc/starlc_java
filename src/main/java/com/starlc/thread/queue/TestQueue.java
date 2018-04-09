/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ���Զ���
 * 
 * @author starlc
 * @since jdk1.7
 * @version V-0.1
 * @Date 2018��4��9�� starlc
 */
public class TestQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue bqueue = new ArrayBlockingQueue(20);
        for (int i = 0; i < 30; i++) {
            // ��ָ��Ԫ����ӵ��˶����У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ����
            bqueue.put(i);
            System.out.println("�����������������Ԫ��:" + i);
        }
        System.out.println("���򵽴����н����������˳�----");
    }
}
