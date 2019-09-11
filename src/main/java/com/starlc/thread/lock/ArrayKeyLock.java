package com.starlc.thread.lock;

import com.starlc.util.Console;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

import sun.misc.Unsafe;

/**
* @Description:    分段锁 错误案例  没有找到真正的CAS
* @Author:         liuc
* @CreateDate:     2019/9/10 23:03
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ArrayKeyLock implements KeyLock{
    private AtomicReferenceArray<Boolean> assist ;
    private static int DEFAULT_CAPACITY;

    static {
        DEFAULT_CAPACITY = 32;
    }

    private int shift ;

    public ArrayKeyLock() {
        this.shift = DEFAULT_CAPACITY;
        assist = new AtomicReferenceArray<>(shift);
        for (int i = 0; i <shift ; i++) {
            assist.set(i,false);
        }
    }

    public ArrayKeyLock(int shift) {
        this.shift = shift;
        assist = new AtomicReferenceArray<>(shift);
        for (int i = 0; i <shift ; i++) {
            assist.set(i,false);
        }
    }

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
    private int getHash(String key){
        return (shift-1)&hash(key);
    }

    @Override
    public void lock(String key) {
        int index = getHash(key);
        while (true) {
            try {
                if (assist.get(index)) {
                    //Console.log("当前线程：{0}key为{1},assist[{2}]为{3}",Thread.currentThread().getName(),key,index,
                    Thread.sleep(10);
                } else {
                    if (!assist.getAndSet(index, true)) {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                throw new Error(e);
            }
        }
    }

    @Override
    public void unLock(String key){
        int index = getHash(key);
        assist.set(index,false);
    }


    public static void main(String[] args) {
        int count = 1000;
        final CountDownLatch latch = new CountDownLatch(count);
        final ArrayKeyLock lock = new ArrayKeyLock(32);
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
