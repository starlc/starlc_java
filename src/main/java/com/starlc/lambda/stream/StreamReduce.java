package com.starlc.lambda.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Description: 测试stream的reduce操作
 * @Author: liuc
 * @CreateDate: 2020/9/17 10:58
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class StreamReduce {
    public static void main(String[] args) {
        Optional<String> reduce = Stream.of("a", "b", "c", null).map(Optional::ofNullable).filter(
                Optional::isPresent).map(Optional::get).reduce((a, b) -> a + "," + b);
        reduce.ifPresent(s -> System.out.println(s));
    }
}
