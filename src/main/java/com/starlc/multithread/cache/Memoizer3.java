package com.starlc.multithread.cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description: 第三个缓存类
 * 仍然使用concurrentHashMap作为缓存容器，然后将value缓存为Future，当调用get时才异步去获取对象
 * 但是仍然存在俩个线程同时计算相同值的情况导致多次put，但是这个概率比2要远小。具体请参考Java并发编程实战88页时序图
 *
 * 复合操作，若没有则添加，是在底层的Map对象上执行的，而这个对象无法通过加锁来确保原子性。
 * @Author: liuc
 * @CreateDate: 2019/9/3 21:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Memoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public  V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();
        }
        V result = null;
        try {
            result = f.get();
        } catch (ExecutionException e) {
            System.out.printf(e.getMessage());
        }
        return result;
    }
}
