package com.suma.lxz.utils;

import lombok.Data;

/**
 * @author luxinzong
 * @date 2018/10/30
 * @description
 */
@Data
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        return result;
    }

}
