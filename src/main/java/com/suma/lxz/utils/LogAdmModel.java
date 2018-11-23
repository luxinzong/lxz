package com.suma.lxz.utils;

import lombok.Data;

import java.util.Date;

/**
 * @Author: luxinzong
 * @Date: 2018/11/23
 * @description
 */
@Data
public class LogAdmModel {
    private Long id;
    private String userId;//操作用户

    private String userName;

    private String admModel;//模块
    private String admEvent;//操作
    private Date createDate;//操作时间
    private String admOptContent;//操作内容
    private String desc;//备注

}
