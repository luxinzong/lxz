package com.suma.lxz.service;

import com.suma.lxz.pojo.User;

/**
 * @author luxinzong
 * @date 2018/10/30
 * @description
 */
public interface UserService {
    int insert(User record);

    int insertSelective(User record);

    User select(User user);

}
