package com.starlc.basicJava.abstractclass;

public abstract class MyClass {
    public int constant = 6;

    public abstract void anoth();
    public void method(){}
}

class Demo{
    protected int method1(int a,int b){
        return 0;
    }
}
class Demo2 extends Demo{

    public int method1(int a,int b){
        return 0;
    }
    private int method1(int a,long b){
        return 0;
    }
}