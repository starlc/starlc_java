package com.starlc.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
* @Description: 之前的中间操作只是对流中数据的处理，最终我们还是要将它们整合输出为一个结果，比如，返回一个最大值，返回一个新的数组，
 *              或者将所有元素进行分组等，这就是规约（末端）操作的作用。
 *              我们常用的末端操作函数有Reduce()和collect();
* @Author:         liuc
* @CreateDate:     2020/8/28 18:20
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class StreamTest2 {

    /**
     * 俩个参数的reduce操作
     */
    public void reduce() {
        String address = "中山北路南京大学仙林校区";
        List<String> aList = new ArrayList<>();
        aList.add("南京");
        aList.add("大学");
        aList.add("仙林校区");
        aList.add("仙林大学城");
        aList.add("中山北路");
        String t="value：";
        String a =aList.stream()
                .reduce(t, (String s, String s2)-> s.concat(s2));
        System.out.println(a);
    }
}
