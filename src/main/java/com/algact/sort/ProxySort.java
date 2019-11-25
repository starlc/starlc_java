package com.algact.sort;

import com.starlc.common.Watcher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySort implements InvocationHandler {
    private Sort target;

    public ProxySort(Sort sort) {
        this.target = sort;
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
        if (method.getName().equals("sort") || method.getName().equals("mySort")){
            int capacity = 100000;
            args[0] = SortUtils.getArr(capacity);
            args[1] = capacity;
            //SortUtils.print((int[])args[0]);
        }
        Watcher watcher = Watcher.get(target.getClass().getName()+"本次排序共花费时间 {0} ms");
        Object o = method.invoke(target,args);
        watcher.end();
        //SortUtils.print((int[])args[0]);
        return o;
    }
}
