/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.designmode.facade;

/**
 * 股票1
 *
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月27日 starlc
 */
public class Stock1 {

    public void sell(){
        System.out.println("股票1卖出");
    }

    public void buy(){
        System.out.println("股票1买入");
    }
}

class Stock2 {

    public void sell(){
        System.out.println("股票2卖出");
    }

    public void buy(){
        System.out.println("股票2买入");
    }
}

class Stock3 {

    public void sell(){
        System.out.println("股票3卖出");
    }

    public void buy(){
        System.out.println("股票3买入");
    }
} 
 