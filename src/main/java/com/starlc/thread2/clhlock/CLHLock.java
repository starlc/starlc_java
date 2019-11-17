package com.starlc.thread2.clhlock;


import java.util.concurrent.atomic.AtomicReference;

public class CLHLock implements Lock {
    AtomicReference<QNode> tail = new AtomicReference<QNode>(new QNode());
    ThreadLocal<QNode> myPred;
    ThreadLocal<QNode> myNode;

    private class QNode{
        volatile  boolean locked;
    }
    public CLHLock() {
        tail = new AtomicReference<QNode>(new QNode());
        myNode = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode();
            }
        };
        myPred = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return null;
            }
        };
    }

    @Override
    public void lock() {
        QNode qnode = myNode.get();
        qnode.locked = true;
        QNode pred = tail.getAndSet(qnode);
        myPred.set(pred);
        while (pred.locked) {
        }
    }

    @Override
    public void unlock() {
        QNode qnode = myNode.get();
        qnode.locked = false;
        myNode.set(myPred.get());
    }

    public static void main(String[] args) {
        final CLHLock lock = new CLHLock();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(String.format("Thread %s Completed", Thread.currentThread().getName()));
                        lock.unlock();
                    }

                 }
            },"Thread"+i).start();
        }
    }
}