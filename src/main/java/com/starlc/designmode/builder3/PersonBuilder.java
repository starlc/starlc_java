/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder3; 

/**
 * 创建复杂对象
 * 现在假设一个人的完整信息由这几部分组成，
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月27日 starlc      
 */
public abstract class PersonBuilder {
   
    
    public abstract void buildName();
    public abstract void buildPhone();
    public abstract void buildAge();
    public abstract void buildAddress();
    public abstract Person getBuilder();

}
 