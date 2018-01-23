/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.template; 

/**
 * 类注释信息
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月23日 starlc      
 */
public class TestMain {

    /** 
     * @Description:  TODO(这里用一句话描述这个方法的作用) 
     * @param:        @param args    
     * @return:       void    
     * @throws 
     */
    public static void main(String[] args) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        TestPaper t1 = new StudentAnswer();
        t1.topic1();
        t1.topic2();
        t1.topic3();
        
        t1 = new StudentAnswer2();
        t1.topic1();
        t1.topic2();
        t1.topic3();
    }

}
 