/**
 * 
 */
package com.starlc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ˮ����ɫע��
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * ��ɫö��
     */
    public enum Color{ BLUE,RED,GREEN};
    
    /**
     * ��ɫ����
     */
    Color fruitColor() default Color.GREEN;

}
