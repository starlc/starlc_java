/**
 * 
 */
package com.starlc.util;

import java.text.MessageFormat;

/**
 * @author liucheng2
 *
 */
public class Console {
	
	public static void log(String pattern,Object... params){
		System.out.println(MessageFormat.format(pattern, params));
	}
	
	public static void log(Object pattern,Object... params){
		log(pattern.toString(), params);
	}
	
	public static void log(Object pattern){
		log(pattern,new Object[0]);
	}
}
