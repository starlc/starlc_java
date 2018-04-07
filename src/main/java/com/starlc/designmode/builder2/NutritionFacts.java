/******************************************************************************
* Copyright (C) 2017 Starlc
*****************************************************************************/
 
package com.starlc.designmode.builder2; 

/**
 * 营养成分
 * 
 * @author   starlc
 * @since	 jdk1.7
 * @version  V-0.1
 * @Date     2018年1月28日 starlc      
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    
    public static class Builder{
        //required parameters
        private final int servingSize;
        private final int servings;
        
        //Optional parameters - initialized to default values
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;
        
        public Builder(int servingSize,int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }
        
        public Builder calories(int val){
            this.calories = val;
            return this;
        }
        
        public Builder fat(int val){
            this.fat = val;
            return this;
        }
        
        public Builder sodium(int val){
            this.sodium = val;
            return this;
        }
        
        public Builder carbohydrate(int val){
            this.carbohydrate = val;
            return this;
        }
        
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
    
    /**
     * 构造函数
     */
    public NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
 