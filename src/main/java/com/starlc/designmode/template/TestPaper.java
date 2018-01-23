/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.template; 

/**
 * 试卷类
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月23日 starlc      
 */
public abstract class TestPaper {
    
    public void topic1(){
        System.out.println("1、xxxx : a,xxx b,xxx c,xxx d,xxx");
        System.out.println("answer : "+answer1());
    }
    
    public void topic2(){
        System.out.println("1、xxxx : a,xxx b,xxx c,xxx d,xxx");
        System.out.println("answer : "+answer2());
    }
    
    public void topic3(){
        System.out.println("1、xxxx : a,xxx b,xxx c,xxx d,xxx");
        System.out.println("answer : "+answer3());
    }
    
    public abstract String answer1();
    
    public abstract String answer2();
    
    public abstract String answer3();
}
 