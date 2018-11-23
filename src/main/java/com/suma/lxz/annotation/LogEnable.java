package com.suma.lxz.annotation;

import java.lang.annotation.*;

/**
 * @Author: luxinzong
 * @Date: 2018/11/23
 * @description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface LogEnable {
    /**
     * 如果为true，则类下面的LogEvent起作用,否则忽略
     * @return
     */
    boolean logEnable() default true;
}
