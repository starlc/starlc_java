package com.starlc.thread.lock;

import com.starlc.util.Console;

import java.util.concurrent.CountDownLatch;

public class TestMapBatchKeyLock {
    public static void main(String[] args) {
        int count = 200;
        final CountDownLatch latch = new CountDownLatch(count);
        final MapBatchKeyLock lock = new MapBatchKeyLock();
        final String[] arr = new String[]{"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a0"};
        final String[] batchArr = new String[]{"a1", "a2", "a3", "a4", "a5"};
        int lockAll = (int) (Math.random() * (10));
        int lockBatch = (int) (Math.random() * (10));

        for (int i = 0; i < count; i++) {
            if (i == lockAll) {
                new Thread(() -> {
                    int a = 0;
                    try {
                        latch.await();
                        //System.out.println("a:"+a);
                        lock.lockAll();
                        Console.log("开始执行全局锁:{0},key为{1}", Thread.currentThread().getName(), lockAll);
                        Thread.sleep(200);
                        Console.log("结束执行全局锁:{0},key为{1}", Thread.currentThread().getName(), lockAll);
                    } catch (Exception e) {
                        throw new Error(e);
                    } finally {
                        lock.unLockALL();
                    }
                }, "count" + i).start();
            } else if (i == lockBatch) {
                new Thread(() -> {
                    int a = 0;
                    try {
                        latch.await();
                        lock.lock(batchArr);
                        Console.log("开始执行批量锁:{0},key为{1}", Thread.currentThread().getName(), lockBatch);
                        Thread.sleep(200);
                        Console.log("结束执行批量锁:{0},key为{1}", Thread.currentThread().getName(), lockBatch);
                    } catch (Exception e) {
                        throw new Error(e);
                    } finally {
                        lock.unLock(batchArr);
                    }
                }, "count" + i).start();
            } else {
                new Thread(() -> {
                    int a = 0;
                    try {
                        latch.await();
                        a = (int) (Math.random() * (10 - 1 + 1));
                        lock.lock(arr[a]);
                        Console.log("开始执行:{0},key为{1}", Thread.currentThread().getName(), arr[a]);
                        Thread.sleep(20);
                        Console.log("结束执行:{0},key为{1}", Thread.currentThread().getName(), arr[a]);
                    } catch (Exception e) {
                        throw new Error(e);
                    } finally {
                        lock.unLock(arr[a]);
                    }

                }, "count" + i).start();
            }
            latch.countDown();
        }
        System.out.println("主线程结束");
    }
}
