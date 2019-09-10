package com.starlc.thread.lock;

import com.starlc.util.Console;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
* @Description:    分段锁 错误案例  没有找到真正的CAS
* @Author:         liuc
* @CreateDate:     2019/9/10 23:03
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ArrayKeyLock {
    private volatile boolean[] assist = new boolean[16];

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
        //System.out.println("hash:"+(15&hash(key)));
        return 15&hash(key);
    }
    public void lock(String key){
        int index = getHash(key);
        while (true) {
            try {
                if (assist[index]) {
                    //Console.log("当前线程：{0}key为{1},assist[{2}]为{3}",Thread.currentThread().getName(),key,index,assist[index]);
                    Thread.sleep(10);
                }else{
                    //
                    break;
                }
            } catch (InterruptedException e) {
                throw new Error(e);
            }
        }
        assist[index]=true;
    }

    public void unLock(String key){
        int index = getHash(key);
        assist[index]=false;
    }


    public static void main(String[] args) {
        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        final ArrayKeyLock lock = new ArrayKeyLock();
        final String[] arr = new String[]{"a1","a2","a3","a4","a5","a6","a7","a8","a9","a0"};
        for (int i = 0; i <count ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int a=0;
                    try {
                        latch.await();
                        a = (int)(Math.random()*(10-1+1));
                        System.out.println("a:"+a);
                        lock.lock(arr[a]);
                        Console.log("开始执行:{0},key为{1},hash为{2}",Thread.currentThread().getName(),arr[a],15&hash(arr[a]));
                        Thread.sleep(20);
                        Console.log("结束执行:{0},key为{1}",Thread.currentThread().getName(),arr[a]);
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
