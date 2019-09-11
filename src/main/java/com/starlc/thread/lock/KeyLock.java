package com.starlc.thread.lock;

public interface KeyLock {
    /**
     * 根据key锁定
     * @param key
     */
    public void lock(String key);

    /**
     * 解锁
     * @param key
     */
    public void unLock(String key);
}
