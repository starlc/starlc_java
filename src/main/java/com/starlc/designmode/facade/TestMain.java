/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.facade; 

import com.sun.org.apache.xpath.internal.FoundIndex;

/**
 * ��ע����Ϣ
 * @Description:   TODO(��һ�仰�������ļ���ʲô) 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��1��27�� starlc      
 */
public class TestMain {
    
    public static void main(String[] args) {
        FundFacade facade = new FundFacade();
        facade.buy();
        
        facade.sell();
    }
}
 