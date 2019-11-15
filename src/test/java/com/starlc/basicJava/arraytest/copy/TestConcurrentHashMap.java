package com.starlc.basicJava.arraytest.copy;
import	java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.ConcurrentMap;

public class TestConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentMap<String,Boolean> map = new ConcurrentHashMap<String, Boolean> ();
        Boolean obj = map.putIfAbsent("a",true);
        Boolean obj2 = map.putIfAbsent("a",false);
        System.out.println(obj);
    }
}
