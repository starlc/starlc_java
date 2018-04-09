/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.thread.exsample1; 

import com.starlc.util.Console;

/**
 *FOO对象
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年4月7日 starlc      
 */
public class Foo {
    private int x = 100; 

    public int getX() { 
        return x; 
    } 

    public int fix(int y) { 
        x = x - y; 
        return x; 
    } 
    
    public synchronized int fix1(int y) {
        x = x-y;
        return x;
    }
    
    public  int fix2(int y) {
        synchronized (this) {
            x = x-y;
            return x;
        }
    }
}
 