package com.starlc.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: stream的基本使用
 * @Author: liuc
 * @CreateDate: 2020/8/28 18:02
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class StreamTest {


    public static void test1() {
        Stream<String> stream = Stream.of("I", "got", "you", "too");

        String[] strArray = new String[]{"a", "b", "c"};
        stream = Arrays.stream(strArray);


        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }

    /**
     * 排序操作(sorted)
     * 1、sorted() 默认使用自然序排序， 其中的元素必须实现Comparable 接口 。
     * 2、sorted(Comparator<? super T> comparator) ：我们可以使用lambada 来创建一个Comparator 实例。可以按照升序或着降序来排序元素。
     * 注意sorted是一个有状态的中间操作，即，只有全部执行完所有的数据才能知道结果。
     */
    public static void sorted() {
        String address = "中山北路南京大学仙林校区";
        List<String> aList = new ArrayList<>();
        aList.add("南京");
        aList.add("大学");
        aList.add("仙林校区");
        aList.add("仙林大学城");
        aList.add("中山北路");
        aList.stream().sorted(Comparator.comparing(a -> address.indexOf(a))).forEach(System.out::println);
        List<String> blist = aList.stream().sorted((a, b) -> address.indexOf(a) - address.indexOf(b)).collect(
                Collectors.toList());
    }

    /**
     * 筛选操作(filter)
     * filter可以对集合进行筛选，它的参数可以是一个lambda表达式，流中的数据将会通过该lambda表达式返回新的流
     * 只保留内部lambda表达式返回结果为true的数据
     *
     * 其它的过滤操作还包括：
     * limit(long maxSize):获得指定数量的流。
     * distinct():通过hashCode和equals去除重复元素。
     */
    public static void filter() {
        String address = "中山北路南京大学仙林校区";
        List<String> aList = new ArrayList<>();
        aList.add("南京");
        aList.add("大学");
        aList.add("仙林校区");
        aList.add("仙林大学城");
        aList.add("中山北路");
        aList.stream().filter(a -> address.indexOf(a) != -1).sorted(
                Comparator.comparing(a -> address.indexOf(a))).forEach(System.out::println);

    }

    /**
     * 映射操作（map）：
     * 映射操作，就像一个管道，可以将流中的元素通过一个函数进行映射，返回一个新的元素。
     * 这样遍历映射，最终返回一个新的容器，注意：这里返回的新容器数据类型可以不与原容器类型相同
     *
     * 遍历每一个元素 并返回一个新的集合
     */
    public void map() {
        String address = "中山北路南京大学仙林校区";
        List<String> aList = new ArrayList<>();
        aList.add("南京");
        aList.add("大学");
        aList.add("仙林校区");
        aList.add("仙林大学城");
        aList.add("中山北路");
        List<Integer> aIntegers =aList.stream()
                .map(str->mapFunc(address, str)).collect(Collectors.toList());
        System.out.println(aIntegers);//.forEach(System.out :: println);
    }

    private int mapFunc(String address,String str) {
        return address.indexOf(str);
    }

}
