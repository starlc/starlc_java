package com.starlc.lambda.optional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        test(Optional.of("id"));

        ofNullable("aaa");
        ofNullable("中文");
        ofNullable(null);
    }

    public static void test(Optional<String> id) {
        id.ifPresent(x-> System.out.println("aaaa:"+x));

    }

    /**
     * map和flatmap的区别
     * map:获取一个新元素（原本几个元素还是几个元素）
     * flatmap 获取一个或者多个新元素（比原来的元素多）
     */
    public static void diffInMapAndFlatMap(){
        Optional<String> strOptional = Optional.of("hello zhangsan");
        String[] s = strOptional.map(w -> w.split(" ")).get();
        //strOptional.flatMap(w->w.split(" ")).get();
    }

    public static void ofNullable(String param){
        String name = Optional.ofNullable(param).orElse("zhangsan");
        System.out.println("name:"+name);
    }


}
