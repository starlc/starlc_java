/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder2; 

/**
 * Ӫ���ɷֹ���
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018��1��28�� starlc      
 */
public class TestMain {
    
    public static void main(String[] args) {
        NutritionFacts facts = new NutritionFacts.Builder(10,5).calories(100).sodium(35).carbohydrate(20).build();
        facts.toString();
    }
}
 