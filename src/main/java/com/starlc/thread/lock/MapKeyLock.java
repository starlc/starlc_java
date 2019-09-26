package com.starlc.thread.lock;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: 关键字锁
 * 场景描述：一堆临界资源，R1 R2 R3 ，但是对同一个资源只允许单线程访问
 * 实现：利用Map来存储Key值，当map中有key的时候，证明当前资源正在使用
 * @Author: liuc
 * @CreateDate: 2019/9/10 17:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MapKeyLock implements KeyLock{
    private final ConcurrentMap<String,Boolean> assist;

    public MapKeyLock() {
        this.assist = new ConcurrentHashMap<>();
    }

    @Override
    public void lock(String key) {
        while (true) {
            try {
                if (Objects.isNull(assist.putIfAbsent(key,Boolean.TRUE))) {
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName()+"key为："+key);
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new Error(e);
            }
        }
    }

    @Override
    public void unLock(String key) {
        assist.remove(key,Boolean.TRUE);
    }

    public static void main(String[] args) {
        int count = 20;
        final CountDownLatch latch = new CountDownLatch(count);
        final MapKeyLock lock = new MapKeyLock();
        final String[] arr = new String[]{"a1","a2","a3","a4","a5","a6","a7","a8","a9","a0"};
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                int a = 0;
                try {
                    latch.await();
                    a = (int) (Math.random() * (10 - 1 + 1));
                    lock.lock(arr[a]);
                    System.out.println("开始执行:" + Thread.currentThread().getName() + ",key为" + arr[a]);
                    Thread.sleep(20);
                    System.out.println("结束执行:" + Thread.currentThread().getName() + ",key为" + arr[a]);
                } catch (Exception e) {
                    throw new Error(e);
                } finally {
                    lock.unLock(arr[a]);
                }
            }, "count" + i).start();
            latch.countDown();
        }
    }
}
