/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder3; 

/**
 * ���崴����
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��1��27�� starlc      
 */
public class ConcreatePersonBuilder extends PersonBuilder {
    
    private Person person = new Person();
    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildName()
     */
    @Override
    public void buildName() {
        System.out.println("�����û�����A");
        person.setFirstName("zhang");
        person.setLastName("san");
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildPhone()
     */
    @Override
    public void buildPhone() {
        System.out.println("�����û�����A");
        person.setPhone("15875269287");
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildAge()
     */
    @Override
    public void buildAge() {
        System.out.println("�����û�����A");
        person.setAge(29);
        
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildAddress()
     */
    @Override
    public void buildAddress() {
        System.out.println("�����û���ַA");
        person.setAddress("xxx·xxx��");
        
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder3.PersonBuilder#show()
     */
    @Override
    public Person getBuilder() {
        return person;
    }

    

}
 