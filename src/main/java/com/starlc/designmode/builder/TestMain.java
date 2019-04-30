/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.designmode.builder;

/**
 * 类注释信息
 * @Description:   TODO(用一句话描述该文件做什么)
 *
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月27日 starlc
 */
public class TestMain {
    public static void main(String[] args) {
        AbstractPersonBuilder pb = new ConcretePersonBuilder();
        PersonDirector pd = new PersonDirector(pb);
        pd.createPerson();
    }
}
 