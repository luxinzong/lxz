package com.suma.lxz.annotation;

/**
 * @Author: luxinzong
 * @Date: 2018/11/23
 * @description
 */
public enum Enum {

    DEFAULT("1"),
    STUDENT("2"),
    REACHER("3");
    private String module;

    private Enum(String index) {
        this.module = index;
    }

    public String getModule() {
        return this.module;
    }
}
