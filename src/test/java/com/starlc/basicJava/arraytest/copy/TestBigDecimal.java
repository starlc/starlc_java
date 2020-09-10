package com.starlc.basicJava.arraytest.copy;

import com.starlc.util.Console;

import java.math.BigDecimal;
import java.util.UUID;

public class TestBigDecimal {

    public static void main(String[] args) {
        BigDecimal score = new BigDecimal(10);
        BigDecimal averageScore = score.divide(new BigDecimal(3),2,BigDecimal.ROUND_FLOOR );
        BigDecimal mult = averageScore.multiply(new BigDecimal(2));

        mult.setScale(1,BigDecimal.ROUND_HALF_UP);
        Console.log(averageScore.toString());
        Console.log(mult.toString());
        Console.log(mult.setScale(1,BigDecimal.ROUND_HALF_UP).toString());
        Console.log(averageScore.setScale(1,BigDecimal.ROUND_HALF_EVEN).toString());
        Console.log(new BigDecimal(3.34).setScale(1,BigDecimal.ROUND_HALF_EVEN).toString());
        Console.log(new BigDecimal(3.34).setScale(1,BigDecimal.ROUND_HALF_UP).toString());

        for (int i = 0; i <100 ; i++) {
            Console.log(UUID.randomUUID().toString());
        }
    }
}
