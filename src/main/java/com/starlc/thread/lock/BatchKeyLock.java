package com.starlc.thread.lock;
/**
* @Description:    支持对key的批量加锁接口
* @Author:         liuc
* @CreateDate:     2019/9/26 16:44
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface BatchKeyLock {

    public void lock(String[] keys);

    public void unLock(String[] keys);

    public void lockAll();

    public void unLockALL();

}
