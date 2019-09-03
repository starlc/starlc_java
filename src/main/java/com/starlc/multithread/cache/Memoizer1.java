package com.starlc.multithread.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 第一个缓存类
 * 采用HashMap作为缓存，在方法上添加锁 ，保证了同时只有一个线程能够进入compute方法，线程安全
 * @Author: liuc
 * @CreateDate: 2019/9/3 21:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Memoizer1<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<>();

    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
