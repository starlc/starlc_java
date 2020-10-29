package com.starlc.thread.lock;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Description: 支持关键字加锁，同时支持批量加锁和全锁
 * @Author: liuc
 * @CreateDate: 2019/9/26 16:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MapBatchKeyLock implements KeyLock, BatchKeyLock {
    private final ConcurrentMap<String, Boolean> assist;
    private volatile boolean isLockAll = false;

    public MapBatchKeyLock() {
        this.assist = new ConcurrentHashMap<>();
    }

    @Override
    public void lock( String[] keys) {
        //1、需要对key去重，去除key为null 和 ""的数据
        String[] uniqueKeys = RemoveDuplicateAndNull(keys);
        //2、先锁全表，再把值都加进去
        try {
            this.lockAll();
            for (String key : uniqueKeys) {
                assist.put(key, true);
            }
        } finally {
            this.unLockALL();
        }
    }

    @Override
    public void unLock( String[] keys) {
        String[] uniqueKeys = RemoveDuplicateAndNull(keys);
        for (String key : uniqueKeys) {
            unLock(key);
        }
    }

    @Override
    public void lockAll() {
        while (true) {
            if (!isLockAll) {
                synchronized (this) {
                    if (!isLockAll && this.assist.isEmpty()) {
                        isLockAll = true;
                        break;
                    }
                }
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public void unLockALL() {
        synchronized (this) {
            this.isLockAll = false;
        }
    }

    @Override
    public void lock( String key) {
        while (true) {
            try {
                if (!isLockAll && Objects.isNull(assist.putIfAbsent(key, Boolean.TRUE))) {
                    break;
                } else {
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                throw new Error(e);
            }
        }
    }

    @Override
    public void unLock( String key) {
        assist.remove(key, Boolean.TRUE);
    }

    /**
     * 去掉空值/""/取出重复
     */
    private static String[] RemoveDuplicateAndNull(String[] keys) {
        List<String> uniqueKeys = new ArrayList<>();
        for (String key : keys) {
            if (key == null || "".equals(key)) {
                continue;
            }
            uniqueKeys.add(key);
        }
        //去重
        Set<String> keySet = new HashSet(uniqueKeys);
        return keySet.toArray(new String[]{});
    }

}
