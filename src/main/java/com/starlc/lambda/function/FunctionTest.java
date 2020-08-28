package com.starlc.lambda.function;

import java.util.function.Function;

/**
* @Description:    Function接口 指定参数类型和返回值类型
* @Author:         liuc
* @CreateDate:     2020/8/27 10:33
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class FunctionTest {
    public static void main(String[] args) {
        Function<String,String> fun = (String name)-> "this function return "+name;
        fun.apply("monkey");
    }
}
