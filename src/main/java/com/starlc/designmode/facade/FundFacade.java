/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package com.starlc.designmode.facade;

/**
 * 基金类
 *
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月27日 starlc
 */
public class FundFacade {
    Stock1 gu1;
    Stock2 gu2;
    Stock3 gu3;

    NationalDebt1 nd1;

    NationalDebt2 nd2;

    public FundFacade(){
        gu1 = new Stock1();
        gu2 = new Stock2();
        gu3 = new Stock3();

        nd1 = new NationalDebt1();
        nd2 = new NationalDebt2();
    }

    public void buy(){
        gu1.buy();
        gu2.buy();
        gu3.buy();

        nd1.buy();
        nd2.buy();
    }

    public void sell(){
        gu1.sell();
        gu2.sell();
        gu3.sell();

        nd1.sell();
        nd2.sell();
    }
}
 