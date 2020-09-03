package com.starlc.lambda.stream;

import java.util.stream.Stream;
/**
* @Description:    stream的延时特性
* @Author:         liuc
* @CreateDate:     2020/9/3 11:16
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class LazyStream {
    public static void main(String[] args) {
        lazy();
        noLazy();
    }

    public static void lazy() {
        Stream.iterate(0, i -> i + 1)
                .map(i -> i + 1)
                .peek(i -> System.out.println("Map: " + i))
                .limit(5)
                .forEach(i -> {});

        System.out.println();
        System.out.println();

        Stream.iterate(0, i -> i + 1)
                .limit(5)
                .map(i -> i + 1)
                .peek(i -> System.out.println("Map: " + i))
                .forEach(i -> {});
    }

    public static void noLazy() {
        Stream.iterate(0, i -> i + 1)
                .flatMap(i -> Stream.of(i, i, i, i))
                .map(i -> i + 1)
                .peek(i -> System.out.println("Map: " + i))
                .limit(5)
                .forEach(i -> {});

        System.out.println();
        System.out.println();

        Stream.iterate(0, i -> i + 1)
                .flatMap(i -> Stream.of(i, i, i, i))
                .limit(5)
                .map(i -> i + 1)
                .peek(i -> System.out.println("Map: " + i))
                .forEach(i -> {});
    }
}
