package com.suma.lxz.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Author luxinzong
 * @Date 2018/11/09
 * @description
 */
@ApiModel
@Data
@Builder(toBuilder = true)
@Getter
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名",dataType = "String",name = "username",example = "lilei")
    private String username;

    @ApiModelProperty(value = "密码",dataType = "String",name = "password",example = "123456")
    private String password;

}