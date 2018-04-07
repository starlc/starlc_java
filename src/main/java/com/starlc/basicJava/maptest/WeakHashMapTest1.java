/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.basicJava.maptest; 

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * 类注释信息
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年4月3日 starlc      
 */
public class WeakHashMapTest1 {
    public static void main(String[] args) throws Exception {
        List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
        for (int i = 0; i < 1000; i++) {
        WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
        d.put(new byte[1000][1000], new byte[1000][1000]);
        maps.add(d);
        System.gc();
        System.err.println(i);
        }
        }
}
 