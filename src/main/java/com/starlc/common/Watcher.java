package com.starlc.common;

import java.text.MessageFormat;

public final class Watcher {
    private long startTime;
    private String message;

    private Watcher(String message) {
        this.startTime = System.currentTimeMillis();
        this.message = message;
    }

    public static Watcher get(){
        return get(null);
    }

    public static Watcher get(String message){
        return new Watcher(message);
    }

    public long end(){
        long cost = System.currentTimeMillis()-startTime;
        System.out.println(MessageFormat.format(this.message,cost));
        return cost;
    }


}
