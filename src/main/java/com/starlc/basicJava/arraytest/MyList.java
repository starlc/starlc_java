/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.basicJava.arraytest; 

import java.util.LinkedList;

/**
 * 类注释信息
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年4月2日 starlc      
 */
public class MyList<E> extends LinkedList<E> {
    
    public String[] toArray() {
        return new String[]{"1", "2", "3"};
    }
}
 