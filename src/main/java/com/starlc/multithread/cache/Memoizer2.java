package com.starlc.multithread.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 第二个缓存类
 * 采用ConcurrentHashMap作为缓存，cache的get和put方法上有锁，但是如果俩个线程的args相同
 * 则会导致多次计算，然后put多次。因此虽然是线程安全的，但存在资源浪费的情况。
 * @Author: liuc
 * @CreateDate: 2019/9/3 21:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Memoizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public  V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
