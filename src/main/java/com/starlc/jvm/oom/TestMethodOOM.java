/**
 * 
 */
package com.starlc.jvm.oom;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

import com.starlc.proxy.ISubject;
import com.starlc.proxy.ISubjectImpl;
import com.starlc.proxy.RequestCtrlInvocationHandle;

/**
 * @author starlc
 *
 */
public class TestMethodOOM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	/**
	 * -Xss256k ��ջ��С����
	 * -verbose:gc -Xms10M -Xmx10M  -XX:PermSize=3M -XX:MaxPermSize=3M -XX:+PrintGCDetails -XX:-UseGCOverheadLimit
	 * ����Perm��  ����class����
	 */
	static void test(){
		ArrayList<ISubject> lst = new ArrayList<ISubject>();
		for (int i = 0; i < 1000000; i++) {
			ISubject s = (ISubject) Proxy.newProxyInstance(TestMethodOOM.class.getClassLoader(),
					new Class[]{ISubject.class}, new RequestCtrlInvocationHandle(new ISubjectImpl()));
			lst.add(s);
		}
	}

}
