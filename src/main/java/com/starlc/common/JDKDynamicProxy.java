package com.starlc.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
* @Description:    通用JDK动态代理
* @Author:         liuc
* @CreateDate:     2019/11/17 21:55
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class JDKDynamicProxy<T> implements InvocationHandler {
    private T target;

    public JDKDynamicProxy(T target) {
        this.target = target;
    }
    /**
     * 获取被代理接口实例对象
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Watcher watcher = Watcher.get();
        Object object = method.invoke(target,args);
        watcher.end();
        return object;
    }
}
