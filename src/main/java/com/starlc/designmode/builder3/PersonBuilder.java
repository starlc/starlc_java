/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder3; 

/**
 * �������Ӷ���
 * ���ڼ���һ���˵�������Ϣ���⼸������ɣ�
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��1��27�� starlc      
 */
public abstract class PersonBuilder {
   
    
    public abstract void buildName();
    public abstract void buildPhone();
    public abstract void buildAge();
    public abstract void buildAddress();
    public abstract Person getBuilder();

}
 