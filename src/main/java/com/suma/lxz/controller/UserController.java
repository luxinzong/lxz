package com.suma.lxz.controller;

import com.suma.lxz.pojo.User;
import com.suma.lxz.service.UserService;
import com.suma.lxz.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luxinzong
 * @date 2018/10/30
 * @description
 */
@RestController
@Api(value = "UserController",description = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户",notes = "传入用户对象，username和password")
    @RequestMapping(value = "/add")
    public Result insertUser(User user) {
        userService.insert(user);
        return Result.success();
    }
}
