/**
 * 
 */
package com.starlc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author starlc
 *
 */
public class RequestCtrlInvocationHandle implements InvocationHandler {
	
	private Object target;
	public RequestCtrlInvocationHandle(Object target) {
		// TODO Auto-generated constructor stub
		this.target = target;
	}
	
	private void before() {
		System.out.println("before");
	}
	
	private void after() {
		System.out.println("after");
	}
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		if ("request".equals(method.getName())) {
			//Date data = new Date();
			before();
			Object objReObject =  method.invoke(target, args);
			after();
			return objReObject;
		}
		return null;
	}

}
