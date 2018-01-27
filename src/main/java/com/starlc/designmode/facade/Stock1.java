/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.facade; 

/**
 * ��Ʊ1
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��1��27�� starlc      
 */
public class Stock1 {
    
    public void sell(){
        System.out.println("��Ʊ1����");
    }
    
    public void buy(){
        System.out.println("��Ʊ1����");
    }
}

class Stock2 {
    
    public void sell(){
        System.out.println("��Ʊ2����");
    }
    
    public void buy(){
        System.out.println("��Ʊ2����");
    }
} 

class Stock3 {
    
    public void sell(){
        System.out.println("��Ʊ3����");
    }
    
    public void buy(){
        System.out.println("��Ʊ3����");
    }
} 
 