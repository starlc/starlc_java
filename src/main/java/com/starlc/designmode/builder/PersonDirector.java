/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder; 

/**
 * ָ����
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��1��27�� starlc      
 */
public class PersonDirector {
    
    private PersonBuilder pb;
    public  PersonDirector(PersonBuilder pb) {
        this.pb = pb;
    }
    
    public void createPerson(){
        pb.buildName();
        pb.buildPhone();
        pb.buildAge();
        pb.buildAddress();
    };
    
}
 