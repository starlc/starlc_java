package com.starlc.multithread.cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description: 第四个缓存类
 * 使用ConcurrentMap来作为引用，通过putIfAbsent来保证复合操作的原子性。
 *
 * 这里我仍然觉得不是完美的，在callable到 f = ft依然存在重复执行的可能
 * 同时书中指出，这里存在缓存污染情况，也就是 当计算取消或者失败，那么这个计算结果将指向过程取消或者失败。
 * @Author: liuc
 * @CreateDate: 2019/9/3 21:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Memoizer4<A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memoizer4(Computable<A, V> c) {
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
            cache.putIfAbsent(arg, ft);
            ft.run();
        }
        V result = null;
        try {
            result = f.get();
        }catch (CancellationException e) {
            cache.remove(arg,f);
        } catch (ExecutionException e) {
            System.out.printf(e.getMessage());
        }
        return result;
    }
}
