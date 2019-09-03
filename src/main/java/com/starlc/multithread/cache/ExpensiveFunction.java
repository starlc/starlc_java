package com.starlc.multithread.cache;

public class ExpensiveFunction implements Computable<String, Integer> {
    @Override
    public Integer compute(String arg) throws InterruptedException {
        //经过长时间的计算
        Thread.sleep(10000);
        return new Integer(arg);
    }
}
