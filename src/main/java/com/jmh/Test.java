package com.jmh;

import com.starlc.common.Watcher;

public class Test {
    public static void main(String[] args) {
        int i = 0;
        Watcher watcher = Watcher.get();
        while (i < 1_000_000_000) {
            i++;
        }
        watcher.end();
        System.out.println(i);
    }
}
