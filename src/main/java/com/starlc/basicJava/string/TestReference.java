package com.starlc.basicJava.string;

import java.util.Arrays;

/**
 * 测试基本类型的引用类型在局部方法中修改值
 * @author starlc
 *
 */
public class TestReference {
	
	public static void main(String[] args) {
		Integer num1 = 6;
		setValue(num1);
		System.out.println(num1);
		
		Integer num2 = new Integer(10);
		setValue(num2);
		System.out.println(num2);
		
		String str1 = "hello jack";
		setString(str1);
		System.out.println(str1);
		
		Export export = new Export();
		export.exchange(export.name, export.ch);
		System.out.println(export.name+" and "+Arrays.toString(export.ch));
		export.exChange(export);
		System.out.println(export);
		
		int big = Integer.MAX_VALUE;
		int bigger = big * 4;
		System.out.println(big);
		System.out.println(bigger);
	}
	
	static void setValue(Integer foo){
		foo = 5;
	}
	
	static void setString(String foo){
		foo = "hello world";
	}
}
