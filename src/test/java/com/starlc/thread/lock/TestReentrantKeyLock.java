package com.starlc.thread.lock;

import com.starlc.util.Console;

import java.util.concurrent.CountDownLatch;

public class TestReentrantKeyLock {
    public static void main(String[] args) {
        int count = 200;
        final CountDownLatch latch = new CountDownLatch(count);
        final ReentrantKeyLock lock = new ReentrantKeyLock();
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
                        a = (int) (Math.random() * (10 - 1 + 1));
                        lock.lock(arr[a]);
                        Console.log("开始执行二次锁:{0},key为{1}", Thread.currentThread().getName(), lockAll);
                        Thread.sleep(200);
                        try {
                            lock.lock(arr[a]);
                            Thread.sleep(200);
                        } finally {
                            lock.unLock(arr[a]);
                        }
                        Console.log("结束执行二次锁:{0},key为{1}", Thread.currentThread().getName(), lockAll);
                    } catch (Exception e) {
                        throw new Error(e);
                    } finally {
                        lock.unLock(arr[a]);
                    }
                }, "count" + i).start();
            } else if (i == lockBatch) {
                new Thread(() -> {
                    int a = 0;
                    try {
                        latch.await();
                        a = (int) (Math.random() * (10 - 1 + 1));
                        lock.lock(arr[a]);
                        Console.log("开始执行批量锁:{0},key为{1}", Thread.currentThread().getName(), lockBatch);
                        Thread.sleep(200);
                        try {
                            lock.lock(arr[a]);
                            Thread.sleep(200);
                            doLock(lock,arr[a]);
                        } finally {
                            lock.unLock(arr[a]);
                        }
                        Console.log("结束执行批量锁:{0},key为{1}", Thread.currentThread().getName(), lockBatch);
                    } catch (Exception e) {
                        throw new Error(e);
                    } finally {
                        lock.unLock(arr[a]);
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

    static void  doLock(ReentrantKeyLock lock,String key){
        try {
            lock.lock(key);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unLock(key);
        }
    }
}
