/**
 * 
 */
package com.starlc.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author starlc
 *
 */
public class TestHeapOOM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testString();
	}
	
	/**
	 * ≤‚ ‘’ª“Á≥ˆ
	 */
	static void test(){
		ArrayList<byte[]> list = new ArrayList<byte[]>();
		for (int i = 0; i < 1024; i++) {
			list.add(new byte[1024*1024*1024]);
		}
	}
	/**
	 * -verbose:gc -Xms10M -Xmx10M -Xss128k -XX:+PrintGCDetails 
	 */
	static void testString(){
		ArrayList<String> lstStr = new ArrayList<String>();
		String a = "abcd";
		for (int i = 0; i < 10000000; i++) {
			lstStr.add(a.intern()+i);
		}
	}
}
