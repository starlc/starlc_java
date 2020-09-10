package com.starlc.lambda.function;

import java.util.function.Supplier;

/**
* @Description:    Supplier不接收任何参数，直接返回类型为T的返回值
* @Author:         liuc
* @CreateDate:     2020/8/27 10:35
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> sup = ()-> "this is a supplier eg";
        System.out.println(sup.get());;

        SupplierTest test = new SupplierTest();
        test.test();

    }

    public void test(){
        Supplier<String> sup2 = this::getResult;
        System.out.println(sup2.get());;
    }

    public String getResult(){
        return "hello man";
    }
}
