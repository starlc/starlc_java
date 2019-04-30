/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.designmode.builder;

/**
 * 具体创建者2
 *
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月27日 starlc
 */
public class ConcreateAbstractPersonBuilder2 extends AbstractPersonBuilder {

    /** (non-Javadoc)
     * @see AbstractPersonBuilder#buildName()
     */
    @Override
    public void buildName() {
        System.out.println("创建用户名称B");
    }

    /** (non-Javadoc)
     * @see AbstractPersonBuilder#buildPhone()
     */
    @Override
    public void buildPhone() {
        System.out.println("创建用户号码B");
    }

    /** (non-Javadoc)
     * @see AbstractPersonBuilder#buildAge()
     */
    @Override
    public void buildAge() {
        System.out.println("创建用户年龄B");

    }

    /** (non-Javadoc)
     * @see AbstractPersonBuilder#buildAddress()
     */
    @Override
    public void buildAddress() {
        System.out.println("创建用户地址B");

    }



}
 