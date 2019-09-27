package com.starlc.thread.lock;

import com.starlc.util.Console;

import java.util.concurrent.CountDownLatch;

public class TestMapBatchKeyLock {
    public static void main(String[] args) {
        int count = 20;
        final CountDownLatch latch = new CountDownLatch(count);
        final MapBatchKeyLock lock = new MapBatchKeyLock();
        final String[] arr = new String[]{"a1","a2","a3","a4","a5","a6","a7","a8","a9","a0"};
        for (int i = 0; i <count ; i++) {
            if (i==10){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int a=0;
                        try {
                            latch.await();
                            a = (int)(Math.random()*(10-1+1));
                            //System.out.println("a:"+a);
                            lock.lockAll();
                            Console.log("开始执行全局锁:{0},key为{1}",Thread.currentThread().getName(),arr[a]);
                            Thread.sleep(20);
                            Console.log("结束执行全局锁:{0},key为{1}",Thread.currentThread().getName(),arr[a]);
                        }catch (Exception e){
                            throw new Error(e);
                        }finally {
                            lock.unLockALL();
                        }
                    }
                },"count"+i).start();
            }else{
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int a=0;
                        try {
                            latch.await();
                            a = (int)(Math.random()*(10-1+1));
                            //System.out.println("a:"+a);
                            lock.lock(arr[a]);
                            Console.log("开始执行:{0},key为{1}",Thread.currentThread().getName(),arr[a]);
                            Thread.sleep(20);
                            Console.log("结束执行:{0},key为{1}",Thread.currentThread().getName(),arr[a]);
                        }catch (Exception e){
                            throw new Error(e);
                        }finally {
                            lock.unLock(arr[a]);
                        }
                    }
                },"count"+i).start();
            }
            latch.countDown();
        }
    }
}
