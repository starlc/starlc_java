package com.starlc.designmode.builder5;

public class Test {


    public static final <T> ResponseResult<T> success(String msg,T data){
        return ResponseResult.<T>builder().data(data).errcode(0L).errmsg(msg).build();
    }

    public static final <T> ResponseResult<T> success(String msg){
        return success(msg,null);
    }

    public static final <T> ResponseResult<T> success(T data){
        return success("",data);
    }

    public static final <T> ResponseResult<T> fail(String msg,T data){
        return ResponseResult.<T>builder().data(data).errcode(1L).errmsg(msg).build();
    }

    public static final <T> ResponseResult<T> fail(String msg){
        return fail(msg,null);
    }

    public static final <T> ResponseResult<T> fail(T data){
        return fail("",data);
    }
}
