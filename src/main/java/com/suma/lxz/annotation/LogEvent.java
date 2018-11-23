package com.suma.lxz.annotation;

import sun.security.pkcs11.Secmod;

import java.lang.annotation.*;

/**
 * @Author: luxinzong
 * @Date: 2018/11/23
 * @description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, ElementType.TYPE})
public @interface LogEvent {
    Enum module() default Enum.DEFAULT;
    EventType event() default EventType.DEFAULT; // 日志事件类型
    String desc() default  ""; // 描述信息
}

