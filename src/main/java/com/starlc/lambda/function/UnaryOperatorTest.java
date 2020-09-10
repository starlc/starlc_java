package com.starlc.lambda.function;

import java.util.function.UnaryOperator;

/**
* @Description:    unaryOperator 接收参数T，通过业务逻辑处理后返回更新后的T类型参数
* @Author:         liuc
* @CreateDate:     2020/8/27 10:57
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class UnaryOperatorTest {
    public static void main(String[] args) {
        UnaryOperator<String> uo =(String test) -> "unaryOperator update string:"+test;
        System.out.println(uo.apply("test"));

    }
}
