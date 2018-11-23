package com.suma.lxz.annotation;

import java.lang.annotation.*;

/**
 * @Author: luxinzong
 * @Date: 2018/11/23
 * @description
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogKey {
    String keyName() default "";

    boolean isUserId() default false;

    boolean isLog() default true;

}
