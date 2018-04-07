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
public class Person {
    
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private int age;
    /**
     * @return the firstName
     */
    protected String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the lastName
     */
    protected String getLastName() {
        return lastName;
    }
    /**
     * @param lastName the lastName to set
     */
    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return the phone
     */
    protected String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    protected void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the address
     */
    protected String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    protected void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the age
     */
    protected int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    protected void setAge(int age) {
        this.age = age;
    }
    
    
}
 