package com.starlc.basicJava.systemtest;

/**
 * @Title: spring-framework-4.3.x
 * @Description:
 * @Author: starlc on 2019/4/19.
 * @Version: 1.0
 */
public class TestSystem {
	public static void  main(String[] args){
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
	}

}
