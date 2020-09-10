package com.starlc.lambda.function;

import java.util.function.Predicate;

/**
* @Description:    Predicat 接收参数T对象，返回一个Boolean类型的对象
* @Author:         liuc
* @CreateDate:     2020/8/27 10:05
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> pr = (String name)-> "true".equals(name);
        System.out.println(pr.test("true"));
    }
}
