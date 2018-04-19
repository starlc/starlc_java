/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ��������
 * ��ν��������ָ�������߳�Ϊ��λ����һ���̻߳�ȡ������֮������߳̿����ٴλ�ȡ�������ϵ��������������߳��ǲ����Ե�
 * synchronized �� ReentrantLock ���ǿ�������
 * �����������������ڷ�ֹ����
 * ʵ��ԭ��ʵ����ͨ��Ϊÿ��������һ�����������һ��ռ�������̡߳�
 * ������Ϊ0ʱ����Ϊ����δ��ռ�еġ��߳�����һ��δ��ռ�е���ʱ��jvm����¼����ռ���ߣ����ҽ������������Ϊ1 ��
 * ���ͬһ���߳��ٴ������������������������
 * ÿ��ռ���߳��˳�ͬ���飬������ֵ���ݼ���ֱ��������Ϊ0,�����ͷš�
 *
 * ���ڸ�����������������:
 * ���าд�˸����synchonized������Ȼ����ø����еķ�����
 * ��ʱ���û�������������ô��δ��뽫����������
 *
 * ���¹�������͸���ĵ����Ǽ�������Ҳ����Ӱ�쵽����������ȡ���Ƿ���ͬһ���������½������Բ���
 * http://blog.csdn.net/aitangyong/article/details/22695399��
 * ʹ��A a = new A()���ַ�ʽ���������ʱ��JVM���ں�̨�����Ƿ����ڴ�ռ䣬Ȼ����ù��캯��ִ�г�ʼ��������
 * ��󷵻��ڴ�ռ�����á�
 * �����캯��ֻ�ǽ��г�ʼ����������������ڴ�ռ䣨�������󣩡�
 * ��������ʵ������������ʱ��JVM��Ϊ�����������ڴ�ռ䣬
 * �����ø���Ĺ��캯����
 * ���ǿ���������⣺������һ����������ʱ������������ڴ��У�
 * ���������ݣ�һ�ݼ̳��Ը��࣬һ���������࣬������������ͬһ������������󣩣�
 * ֻ������java�﷨�ṩ��this��super�ؼ������������ܹ�������Ҫ������2�����ݶ��ѡ�
 * �����Ͳ���������͸���ĸ����ʵ����ֻ���������û�и������
 *
 */
public class LockTest1 extends FLockTest1 implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    public synchronized void methodA() {
        System.out.println(Thread.currentThread().getName() + "this is Method A start");
        // ��ʱ����
        methodB();
        System.out.println(Thread.currentThread().getName() + "this is Method A end");
    }

    public synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + "this is Method B start");
        System.out.println(Thread.currentThread().getName() + "this is Method B end");
    }

    public synchronized void test() {
        System.out.println("this is childrenTest started");
        super.test();
        System.out.println("this is childrenTest end");
    }

    @Override
    public void run() {
        // ���Ա����е�ͬ������
        methodA();
        // ���Ը�������������
        test();
        // ����ReentrantLock
        reentrantLockTest1();

    }

    public static void main(String[] args) {
        LockTest1 t1 = new LockTest1();
        Thread t = new Thread(t1);
        t.start();
        t1.methodB();
    }

    public void reentrantLockTest1() {
        lock.lock();
        System.out.println("this is reentrantLockTest1");
        reentrantLockTest2();
        lock.unlock();
    }

    public void reentrantLockTest2() {
        lock.lock();
        System.out.println("this is reentrantLockTest2");
        lock.unlock();
    }

}

class FLockTest1 {
    public synchronized void test() {
        System.out.println("this is Father Class test started");
        System.out.println("this is Father Class test end");
    }
}
