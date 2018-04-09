/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.thread.deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * ��������ջ
 * 
 * @author starlc
 * @since jdk1.7
 * @version V-0.1
 * @Date 2018��4��9�� starlc
 */
public class TestDeque {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque bDeque = new LinkedBlockingDeque(20);
        for (int i = 0; i < 30; i++) {
            // ��ָ��Ԫ����ӵ�������ջ�У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ����
            bDeque.putFirst(i);
            System.out.println("������ջ�������Ԫ��:" + i);
        }
        System.out.println("���򵽴����н����������˳�----");
    }
}
