/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder3; 

/**
 * ��ע����Ϣ
 * @Description:   TODO(��һ�仰�������ļ���ʲô) 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��1��28�� starlc      
 */
public class TestMain {

    /** 
     * @Description:  TODO(������һ�仰�����������������) 
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
 