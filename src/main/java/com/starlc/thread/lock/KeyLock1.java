package com.starlc.thread.lock;

/**
 * @Description: 关键字锁
 * 场景描述：一堆临界资源，R1 R2 R3 ，但是对同一个资源只允许单线程访问
 * 实现：没有办法真正给每一个类型的R1都分配一个锁，借助hash算法，将key取hash值，值相同的视为同一类资源
 * @Author: liuc
 * @CreateDate: 2019/9/10 17:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class KeyLock1 {
    /**
     * 最大值7FFFFFFF 共4*8-1 31个锁
     */
    private volatile int assist = 0;

    /**
     * ^（同为0，异为1）
     * >>>（无符号右移运算符）
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void lock(String key){
        //对key进行hash计算
        int h = getHash(key);
        //判断assist的 第h位是否为1 不为1则通过
        while (compareAndSet(h)){
            break;
        }
    }

    private int getHash(String key){
        return 31&hash(key);
    }
    private boolean compareAndSet(int value){
        return false;
    }

    public void  unLock(String key){

    }


}
