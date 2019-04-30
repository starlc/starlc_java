/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.designmode.builder;

/**
 * 创建复杂对象
 * 现在假设一个人的完整信息由这几部分组成，
 *
 * @author starlc
 * @version V-0.1
 * @since jdk1.7
 * @Date 2018年1月27日 starlc
 */
public abstract class AbstractPersonBuilder {


	public abstract void buildName();

	public abstract void buildPhone();

	public abstract void buildAge();

	public abstract void buildAddress();


}
 