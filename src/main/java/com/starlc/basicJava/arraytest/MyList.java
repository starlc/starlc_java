/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.basicJava.arraytest; 

import java.util.LinkedList;

/**
 * ��ע����Ϣ
 * @Description:   TODO(��һ�仰�������ļ���ʲô) 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��4��2�� starlc      
 */
public class MyList<E> extends LinkedList<E> {
    
    public String[] toArray() {
        return new String[]{"1", "2", "3"};
    }
}
 