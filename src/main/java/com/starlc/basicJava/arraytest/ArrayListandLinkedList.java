/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.basicJava.arraytest;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 类注释信息
 * 
 * @Description: TODO(用一句话描述该文件做什么)
 * 
 * @author starlc
 * @since jdk1.7
 * @version V-0.1
 * @Date 2018年4月3日 starlc
 */
public class ArrayListandLinkedList {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList list = new ArrayList();
        Object obj = new Object();
        for (int i = 0; i < 5000000; i++) {
            list.add(obj);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        LinkedList list1 = new LinkedList();
        Object obj1 = new Object();
        for (int i = 0; i < 5000000; i++) {
            list1.add(obj1);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        Object obj2 = new Object();
        for (int i = 0; i < 1000; i++) {
            list.add(0, obj2);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList插入1000个元素耗时"+(end - start));

        start = System.currentTimeMillis();
        Object obj3 = new Object();
        for (int i = 0; i < 1000; i++) {
            list1.add(obj1);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList插入1000个元素耗时"+(end - start));

        start = System.currentTimeMillis();
        list.remove(0);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        list1.remove(250000);
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
