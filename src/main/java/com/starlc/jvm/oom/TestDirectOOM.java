/**
 * 
 */
package com.starlc.jvm.oom;

import java.nio.ByteBuffer;

/**
 * @author starlc
 *
 */
public class TestDirectOOM {

	/**
	 * @param args
	 * ���ٶѿռ�
	 * ���ⴥ��GC
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			ByteBuffer.allocate(1024*1024*1024);
			System.out.println(i);
			System.gc();
		}
	}
	
}
