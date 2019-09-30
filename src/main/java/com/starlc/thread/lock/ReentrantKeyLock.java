package com.starlc.thread.lock;

import com.starlc.util.Console;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Description: 可重入的关键字锁 ，一个锁是否可重入，主要就是将获得锁的线程记录下来，如果进入方法的线程可获得锁的线程是同一个线程，那么我们就可以直接获得锁，不需要等待。
 * @Author: liuc
 * @CreateDate: 2019/9/30 14:07
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReentrantKeyLock implements KeyLock {
    private final ConcurrentMap<String,Helper> assist;

    public ReentrantKeyLock() {
        this.assist = new ConcurrentHashMap<>();
    }

    @Override
    public void lock(String key) {
        while (true) {
            try {
                Thread t = Thread.currentThread();
                //第一次请求
                if (Objects.isNull(assist.putIfAbsent(key,new Helper(t)))) {
                    break;
                }else if(compareAndSet(key,t)){
                    //重复进入
                    Console.log("{0}又进来了,key为{1}",t.getName(),key);
                    break;
                } else {
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new Error(e);
            }
        }
    }

    /**
     * 如何保证这个类的线程安全
     * @param key
     * @param t
     * @return
     */
    private boolean compareAndSet(String key,Thread t) {
        Helper helper = assist.get(key);
        if (helper!=null && helper.getLockThread().equals(t)){
            helper.increCount();
            return true;
        }
        return false;
    }

    /**
     * 解锁，俩种情形，一种是只加锁了一次
     * 一种是多次
     * @param key
     */
    @Override
    public void unLock(String key) {
        Thread t = Thread.currentThread();
        if (!assist.remove(key,new Helper(t))){
            Helper helper = assist.get(key);
            if (helper.getLockThread().equals(t)){
                helper.decreCount();
            }
        }
    }

    /**
     * 辅助类，记录加锁的次数，和加锁的线程
     */
    static class Helper{
        private int count;
        private Thread lockThread;

        public Helper() {
        }

        public Helper( Thread lockThread) {
            this.count = 0;
            this.lockThread = lockThread;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void increCount(){
            this.count+=1;
        }
        public void decreCount(){
            this.count-=1;
        }

        public Thread getLockThread() {
            return lockThread;
        }

        public void setLockThread(Thread lockThread) {
            this.lockThread = lockThread;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Helper)) return false;
            Helper helper = (Helper) o;
            return count == helper.count &&
                    Objects.equals(lockThread, helper.lockThread);
        }

        @Override
        public int hashCode() {
            return Objects.hash(count, lockThread);
        }
    }
}
