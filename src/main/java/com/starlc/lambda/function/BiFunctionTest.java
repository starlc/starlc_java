package com.starlc.lambda.function;

import java.util.function.BiFunction;
/**
* @Description:    Bifunction 接收第一个参数T，第二个参数U，返回R类型参数。
* @Author:         liuc
* @CreateDate:     2020/8/27 11:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BiFunctionTest {
    public static void main(String[] args) {
        BiFunction<String,Integer,String> bi = (String name,Integer age)->"my name is "+name+" ,and age is "+age;
        System.out.println(bi.apply("zhangsan",22));
    }
}
