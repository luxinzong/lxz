package com.suma.lxz.annotation;

/**
 * @Author: luxinzong
 * @Date: 2018/11/23
 * @description
 */
public enum EventType {
    ADD("2", "add"),
    DEFAULT("1", "default"),
    DELETE("4", "delete-single"),
    LOGIN("10", "login"),
    LOGOUT("11", "logout"),
    UPDATE("3", "update");

    private EventType(String index, String name) {
        this.event = index;
        this.name = name;
    }

    private String event;
    private String name;

    public String getEvent() {
        return event;
    }

    public String getName() {
        return name;
    }
}
