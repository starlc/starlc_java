/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder3; 

/**
 * 类注释信息
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月28日 starlc      
 */
public class TestMain {

    /** 
     * @Description:  TODO(这里用一句话描述这个方法的作用) 
     * @param:        @param args    
     * @return:       void    
     * @throws 
     */
    public static void main(String[] args) {
        PersonBuilder pbBuilder = new ConcreatePersonBuilder();
        PersonDirector pd = new PersonDirector(pbBuilder);
        pd.createPerson();
        pbBuilder.getBuilder();
    }

}
 