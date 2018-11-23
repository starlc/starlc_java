/**
 * 
 */
package com.starlc.clsloader.sub;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sun.org.apache.bcel.internal.generic.LoadClass;

/**
 * @author starlc
 *
 */
public class TestClsLoader extends ClassLoader{

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		ClassLoader classLoader = TestClsLoader.class.getClassLoader();
		byte[] bHelloLoader = new byte[]{};//loadClass("com.starlc.clsloader.sub.HelloClassLoader");
		Method md_defineClassMethod = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class,int.class,int.class);
		md_defineClassMethod.setAccessible(true);
		md_defineClassMethod.invoke(classLoader, bHelloLoader,0,bHelloLoader.length);
		md_defineClassMethod.setAccessible(false);
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.loadClass(name);
	}

}
