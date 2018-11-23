/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.basicJava.maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
public class WeakHashMapTest {
    public static void main(String[] args) throws Exception {
        String a = new String("a");
        String b = new String("b");
        Map weakmap = new WeakHashMap();
        Map map = new HashMap();
        map.put(a, "aaa");
        map.put(b, "bbb");
        weakmap.put(a, "aaa");
        weakmap.put(b, "bbb");
        map.remove(a);
        a=null;
        b=null;
        System.gc();
        Iterator i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry en = (Map.Entry)i.next();
            System.out.println("map:"+en.getKey()+":"+en.getValue());
        }
        Iterator j = weakmap.entrySet().iterator();
        while (j.hasNext()) {
            Map.Entry en = (Map.Entry)j.next();
            System.out.println("weakmap:"+en.getKey()+":"+en.getValue());
        }
    }
}
 