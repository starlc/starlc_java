/******************************************************************************
 * Copyright (C) 2017 Starlc
 *****************************************************************************/

package starlc_java.com.starlc.basicJava.arraytest;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.starlc.basicJava.arraytest.Father;
import com.starlc.basicJava.arraytest.MyList;
import com.starlc.basicJava.arraytest.Son;

/**
 * 类注释信息
 * 
 * @Description: TODO(用一句话描述该文件做什么)
 * 
 * @author starlc
 * @since jdk1.7
 * @version V-0.1
 * @Date 2018年4月2日 starlc
 */
public class TestArray {

    /**
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: @param args
     * @return: void
     * @throws
     */
    @Test
    public void test() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        Son[] sons = new Son[] { new Son(), new Son() };
        System.out.println(sons.getClass());

        Father[] fathers = sons;
        System.out.println(fathers.getClass());

        // fathers[0] = new Father();
        // java.lang.ArrayStoreException: com.starlc.basicJava.arraytest.Father
        
        
        Son son = new Son();
        Father father = son;
        father = new Father();
    }
    
    
    /**
     * 测试：c.toArray might (incorrectly) not return Object[] (see 6260652) 这个官方 bug
     */
    @org.junit.Test
    public void test3() {
        List<String> ss = new LinkedList<String>();             // LinkedList toArray() 返回的本身就是 Object[]
        ss.add("123");
        Object[] objs = ss.toArray();
        objs[0] = new Object();

        // 此处说明了：c.toArray might (incorrectly) not return Object[] (see 6260652)
        ss = new MyList<String>();
        //ss.set(1, "234"); //java.lang.IndexOutOfBoundsException: Index: 1, Size: 0
        objs = ss.toArray();
        System.out.println(objs[1]);
        System.out.println(objs.getClass());        // class [Ljava.lang.String;
        objs[0] = new Object();                         // java.lang.ArrayStoreException: java.lang.Object
    }
}
