package com.starlc.lambda.function;

import java.util.function.BinaryOperator;
/**
* @Description:    BinaryOperator 接收两个参数T，返回更新后的T类型参数。
* @Author:         liuc
* @CreateDate:     2020/8/27 10:05
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperator<String>
                bo = (String name,String sport)->"test BinaryOperator，my name is "+name+",my favourite sport is "+sport;
        System.out.println(bo.apply("Tom", "basketball"));
    }
}
