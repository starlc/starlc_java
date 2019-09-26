package com.starlc.thread.lock;

import com.starlc.util.Console;

import java.util.concurrent.CountDownLatch;

public class TestArrayKeyLock {
    /**
     * ^（同为0，异为1）
     * >>>（无符号右移运算符）
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        int count = 1000;
        final CountDownLatch latch = new CountDownLatch(count);
        final SegmentKeyLock lock = new SegmentKeyLock(32);
        final String[] arr = new String[]{"a1","a2","a3","a4","a5","a6","a7","a8","a9","a0"};
        for (int i = 0; i <count ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int a=0;
                    try {
                        latch.await();
                        a = (int)(Math.random()*(10-1+1));
                        //System.out.println("a:"+a);
                        lock.lock(arr[a]);
                        Console.log("开始执行:{0},key为{1},hash为{2}",Thread.currentThread().getName(),arr[a],31&hash(arr[a]));
                        Thread.sleep(20);
                        Console.log("结束执行:{0},key为{1},hash为{2}",Thread.currentThread().getName(),arr[a],31&hash(arr[a]));
                    }catch (Exception e){
                        throw new Error(e);
                    }finally {
                        lock.unLock(arr[a]);
                    }
                }
            },"count"+i).start();
            latch.countDown();
        }
    }
}
