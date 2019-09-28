package com.starlc.threadPool.useful;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
* @Description:    利用信号量来控制正在执行的和等待执行的任务数量
* @Author:         liuc
* @CreateDate:     2019/9/29 0:19
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BoundedExecutor {
    private final Executor exec;

    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec, int bound) {
        this.exec = exec;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command)throws InterruptedException{
        semaphore.acquire();

        try {
            exec.execute(()->{
                try {
                    command.run();
                } finally {
                    semaphore.release();
                }
            });
        } catch (RejectedExecutionException e) {
            semaphore.release();
        }
    }
}
