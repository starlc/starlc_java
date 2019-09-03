package com.starlc.basicJava.arraytest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
* @Description:    测试内部表达式 返回true的结果被保留
* @Author:         liuc
* @CreateDate:     2019/7/25 19:17
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class FilterTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5};
        Integer[] b = new Integer[]{2, 3, 7, 8};
        List<Integer> aa = Arrays.asList(a).stream().filter(s -> Arrays.asList(b).contains(s)).collect(
                Collectors.toList());
        System.out.println(aa.size());
    }
}
