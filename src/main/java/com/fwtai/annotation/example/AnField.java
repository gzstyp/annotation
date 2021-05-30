package com.fwtai.annotation.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnField{

    String value() default "";//注解的参数 todo 注解的参数,如果只有一个成员参数,一般建议参数名为 value
}