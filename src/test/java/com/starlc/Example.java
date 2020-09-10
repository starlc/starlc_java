package com.starlc;

public class Example {
    String str = new String("hello");
    char[] ch = {'a','b'};
    void exchange(String str,char[] ch){
        str = "test ok";
        ch[0] = 'c';
    }

    public static void main(String[] args) {
        Example ex = new Example();
        ex.exchange(ex.str,ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
        //hello and cb
    }
}
