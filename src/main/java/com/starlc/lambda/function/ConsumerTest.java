package com.starlc.lambda.function;

import java.util.function.Consumer;
/**
* @Description:    Consumer 接收参数T对象，不返回任何对象。
 * 其内部参数为 一个无返回值的方法，参数类型为单个 即泛型T
* @Author:         liuc
* @CreateDate:     2020/8/27 10:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String>  cs =(String name)-> System.out.println("this is a "+name);
        cs.accept("apple");
    }
}
