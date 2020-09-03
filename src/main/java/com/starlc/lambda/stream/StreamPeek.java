package com.starlc.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @Description: stream流的peek操作
 * peek 操作 一般用于不想改变流中元素本身的类型或者只想元素的内部状态时；
 * 而 map 则用于改变流中元素本身类型，即从元素中派生出另一种类型的操作。
 * 俩者都是中间操作
 * @Author: liuc
 * @CreateDate: 2020/9/3 15:44
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class StreamPeek {

    public static void main(String[] args) {
        peek();
        map();
        generate();
    }

    /**
     * peek 一般用于不需要改变元素本身的类型 只改变元素内部状态时
     */
    public static void peek() {
        Stream<String> stream = Stream.of("hello", "felord.cn");
        stream.peek(a->a=a+"1").forEach(System.out::println);
        Stream<User> userStream = Stream.of(new User("1","张三"),new User("2","李四"));
        userStream.peek(user -> user.setName(user.name+" hello")).forEach(System.out::println);

        List<String> keys = Arrays.asList("hello", "felord.cn");
        keys.stream().peek(System.out::println);//这种方式有问题 只是中间操作

        System.out.println("peek end");
    }

    public static void map() {
        Stream<String> stream = Stream.of("hello", "felord.cn");
        stream.map(a->a=a+"1").forEach(System.out::println);
    }

    public static void generate(){
        //不添加limit就会无限生成
        Stream<String> stream = Stream.generate(()-> UUID.randomUUID().toString()).limit(20);
        stream.forEach(System.out::println);
        Stream<String> stream2 = Stream.iterate("a",(s)-> s+1).limit(20);
        stream2.forEach(System.out::println);
    }
    static class User{
        String id;
        String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
