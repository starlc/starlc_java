package com.starlc.jpinyin;

import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.util.Arrays;
import java.util.List;

public class JPinYinTest {
    public static void main(String[] args) throws PinyinException {
        String str = "zhangsan";
        String out = PinyinHelper.convertToPinyinString(str,",", PinyinFormat.WITHOUT_TONE);
        System.out.println(out);
        String str2 = "张三";
        String out2 = PinyinHelper.convertToPinyinString(str,",", PinyinFormat.WITHOUT_TONE);
        System.out.println(out2);
        char a = "a".charAt(0);
        char b = "1".charAt(0);
        char c = "b".charAt(0);
        System.out.println(Character.toUpperCase(a)-Character.toUpperCase(b));
        System.out.println(a-b);

        System.out.println(Integer.valueOf(a));
        System.out.println(Integer.valueOf(b));
        System.out.println(String.valueOf(a).compareToIgnoreCase(String.valueOf(b)));
        System.out.println(String.valueOf(a).compareToIgnoreCase(String.valueOf(c)));
        testChinese();
    }

    public static void testChinese(){
        List<String> lst = Arrays.asList("张三","李四","liyang","王五","zhangs","dd","11");
        lst.stream().sorted((a,b)->{
            char strA = a.charAt(0);
            char strB = b.charAt(0);
            if (ChineseHelper.isChinese(strA)){
                try {
                    strA = PinyinHelper.convertToPinyinString(String.valueOf(strA),",",PinyinFormat.WITHOUT_TONE).charAt(0);
                    strB = PinyinHelper.convertToPinyinString(String.valueOf(strB),",",PinyinFormat.WITHOUT_TONE).charAt(0);
                    return strA > strB ? 1 : strA == strB ? 0 :-1;
                } catch (PinyinException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }).forEach(x-> System.out.println(x));
    }
}
