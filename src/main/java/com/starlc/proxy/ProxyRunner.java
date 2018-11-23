/**
 * 
 */
package com.starlc.proxy;

import java.lang.reflect.Proxy;


/**
 * @author starlc
 *
 */
public class ProxyRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISubject subject = (ISubject) Proxy.newProxyInstance(ProxyRunner.class.getClassLoader(),
				new Class[]{ISubject.class}, new RequestCtrlInvocationHandle(new ISubjectImpl()));
		subject.request();
	}

}
