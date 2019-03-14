package com.chenxi.springboot01practice.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface Admin {
    String value() default "";
}
