/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder3; 

/**
 * 具体创建者
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月27日 starlc      
 */
public class ConcreatePersonBuilder extends PersonBuilder {
    
    private Person person = new Person();
    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildName()
     */
    @Override
    public void buildName() {
        System.out.println("创建用户名称A");
        person.setFirstName("zhang");
        person.setLastName("san");
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildPhone()
     */
    @Override
    public void buildPhone() {
        System.out.println("创建用户号码A");
        person.setPhone("15875269287");
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildAge()
     */
    @Override
    public void buildAge() {
        System.out.println("创建用户年龄A");
        person.setAge(29);
        
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildAddress()
     */
    @Override
    public void buildAddress() {
        System.out.println("创建用户地址A");
        person.setAddress("xxx路xxx号");
        
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder3.PersonBuilder#show()
     */
    @Override
    public Person getBuilder() {
        return person;
    }

    

}
 