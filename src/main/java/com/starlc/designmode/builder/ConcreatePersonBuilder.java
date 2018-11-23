/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.designmode.builder;

/**
 * 具体创建者
 *
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月27日 starlc
 */
public class ConcreatePersonBuilder extends PersonBuilder {

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildName()
     */
    @Override
    public void buildName() {
        System.out.println("创建用户名称A");
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildPhone()
     */
    @Override
    public void buildPhone() {
        System.out.println("创建用户号码A");
    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildAge()
     */
    @Override
    public void buildAge() {
        System.out.println("创建用户年龄A");

    }

    /** (non-Javadoc)
     * @see com.starlc.designmode.builder.PersonBuilder#buildAddress()
     */
    @Override
    public void buildAddress() {
        System.out.println("创建用户地址A");

    }



}
 