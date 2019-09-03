package com.starlc.multithread.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description: 第五个缓存类
 * 在OPPO面试的时候曾经碰到过类似使用缓存的问题，后来一直在思考是否可以使用volatile来保证同步性
 * 在这里我们把需求简化一下，即只考虑map里面缓存a ，没有则添加这种场景
 *
 * 这里有几个隐藏的点，第一，希望对a的获取是延迟加载的，
 * 第二，保证对a值的计算只有一次
 * @Author: liuc
 * @CreateDate: 2019/9/3 21:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Memoizer5<A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, V> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;
    private volatile V a = null;
    private final Object lock = new Object();

    public Memoizer5(Computable<A, V> c) {
        this.c = c;
    }

    /**
     *
     * @param arg
     * @return
     * @throws InterruptedException
     */
    @Override
    public V compute(A arg) throws InterruptedException {
        a = cache.get(arg);
        if (a == null) {
            synchronized (lock) {
                if (a == null) {
                    a = c.compute(arg);
                    cache.put(arg, a);
                }
            }
        }
        return a;
    }
}
