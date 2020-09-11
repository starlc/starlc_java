package com.starlc.collection.compara;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
        Comparator<Object> com= Collator.getInstance(java.util.Locale.CHINA);

        String[] newArray={"中山","汕头","广州","安庆","阳江","南京","武汉","北京","安阳","北方","重庆"};
        List<String> list = Arrays.asList(newArray);
        Collections.sort(list, com);
        for(String i:list){
            System.out.print(i+"  ");
        }
    }

}
