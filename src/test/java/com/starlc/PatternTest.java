package com.starlc;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    @Test
    public void test(){
        String name = "赵　桢赵　桢";
        String dbname = "赵  桢";
        name = name.replaceAll("\\s*|\t|\r|\n","");
        System.out.println(name);

        name = name.replace((char) 12288, ' ');
        System.out.println(name);

        name = name.replaceAll("\\s+","");
        System.out.println(name);
    }


    protected String replaceBlank(String str){
        String dest = null;
        if(str == null){
            return dest;
        }else{
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
            return dest;
        }
    }
}
