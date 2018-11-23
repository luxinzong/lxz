package com.suma.lxz.service.serviceImpl;

import com.google.common.collect.Lists;
import com.suma.lxz.dao.UserMapper;
import com.suma.lxz.pojo.User;
import com.suma.lxz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.sort;

/**
 * @author luxinzong
 * @date 2018/10/30
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User select(User user) {
        return userMapper.select(user);
    }

    @Override
    public int insert(User record) {
        List<User> userList;
        userList = new Lists.newArrayList();
        userList.add(record);
        User[] users = (User[]) userList.toArray();

        Arrays.sort(users,(User o1,User o2) -> o1.getPassword().compareTo(o2.getPassword()));

        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

}
