package com.starlc;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestList {

    @Test
    public void test(){
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(a->{
            if (a == 3) {
                return;
            } else {
                System.out.println("else:"+a);
            }
            System.out.println(a);
        });
    }

    @Test
    public void testInterupt(){

        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(500);

                if (i==5){throw new InterruptedException("ss");}
                System.out.println(i);
            } catch (InterruptedException e) {
                //Thread.currentThread().interrupt();
            }

        }
    }

    @Test
    public void testOptional(){
        String str = null;
        Optional.ofNullable(str).map(s->{
            System.out.println(s);
            return true;
        }).orElseGet(()->{
            System.out.println("else");
            return true;
        });


    }

    @Test
    public void testArr() {
        System.out.println(Arrays.asList("a","b").stream().collect(Collectors.joining(",")));
        Map map = new HashMap();
        System.out.println((String)map.get("a"));
    }
}
