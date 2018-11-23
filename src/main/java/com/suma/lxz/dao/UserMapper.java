package com.suma.lxz.dao;

import com.suma.lxz.pojo.User;

/**
 * @Author luxinzong
 *
 */
public interface UserMapper {
    /**
     * 保存用户
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 按条件进行保存用户
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 查询用户
     * @param user
     * @return
     */
    User select(User user);
}