package com.fwtai.annotation.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnMethod{

    String value() default "v";//默认是value,value可以不指定的,todo 如果只有一个成员参数,一般参数名为 value
    String name() default "";
}
