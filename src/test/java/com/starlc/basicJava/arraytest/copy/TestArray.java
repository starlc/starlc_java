/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.basicJava.arraytest.copy;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.starlc.basicJava.arraytest.Father;
import com.starlc.basicJava.arraytest.MyList;
import com.starlc.basicJava.arraytest.Son;

/**
 * ��ע����Ϣ
 * 
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * 
 * @author starlc
 * @since jdk1.7
 * @version V-0.1
 * @Date 2018��4��2�� starlc
 */
public class TestArray {

    /**
     * @Description: TODO(������һ�仰�����������������)
     * @param: @param args
     * @return: void
     * @throws
     */
    @Test
    public void test() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        Son[] sons = new Son[] { new Son(), new Son() };
        System.out.println(sons.getClass());

        Father[] fathers = sons;
        System.out.println(fathers.getClass());

        // fathers[0] = new Father();
        // java.lang.ArrayStoreException: com.starlc.basicJava.arraytest.Father
        
        
        Son son = new Son();
        Father father = son;
        father = new Father();
    }
    
    
    /**
     * ���ԣ�c.toArray might (incorrectly) not return Object[] (see 6260652) ����ٷ� bug
     */
    @org.junit.Test
    public void test3() {
        List<String> ss = new LinkedList<String>();             // LinkedList toArray() ���صı������ Object[]
        ss.add("123");
        Object[] objs = ss.toArray();
        objs[0] = new Object();

        // �˴�˵���ˣ�c.toArray might (incorrectly) not return Object[] (see 6260652)
        ss = new MyList<String>();
        //ss.set(1, "234"); //java.lang.IndexOutOfBoundsException: Index: 1, Size: 0
        objs = ss.toArray();
        System.out.println(objs[1]);
        System.out.println(objs.getClass());        // class [Ljava.lang.String;
        objs[0] = new Object();                         // java.lang.ArrayStoreException: java.lang.Object
    }
}
