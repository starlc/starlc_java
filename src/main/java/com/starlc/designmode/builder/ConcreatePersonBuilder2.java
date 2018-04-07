/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder; 

/**
 * ���崴����2
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��1��27�� starlc      
 */
public class ConcreatePersonBuilder2 extends PersonBuilder {

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildName()
     */
    @Override
    public void buildName() {
        System.out.println("�����û�����B");
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildPhone()
     */
    @Override
    public void buildPhone() {
        System.out.println("�����û�����B");
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildAge()
     */
    @Override
    public void buildAge() {
        System.out.println("�����û�����B");
        
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildAddress()
     */
    @Override
    public void buildAddress() {
        System.out.println("�����û���ַB");
        
    }

    

}
 