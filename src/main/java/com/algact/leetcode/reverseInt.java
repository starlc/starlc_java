package com.algact.leetcode;

public class reverseInt {

    public int reverse(int x) {
        long re = 0;
        while (x != 0) {
            int pop = x % 10;
            re = re * 10 + pop;
            if (re > Integer.MAX_VALUE || re < Integer.MIN_VALUE) {
                re = 0;
            }
            x /= 10;
        }
        return (int) re;
    }
}
