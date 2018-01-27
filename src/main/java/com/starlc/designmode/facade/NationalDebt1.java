/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.facade; 

/**
 * 国债1
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月27日 starlc      
 */
public class NationalDebt1 {
    public void sell(){
        System.out.println("国债1卖出");
    }
    
    public void buy(){
        System.out.println("国债1买入");
    }
}

class NationalDebt2 {
    public void sell(){
        System.out.println("国债2卖出");
    }
    
    public void buy(){
        System.out.println("国债2买入");
    }
}
 