package com.starlc.multithread.cache;

/**
 *  计算接口
 * @param <A>
 * @param <V>
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
