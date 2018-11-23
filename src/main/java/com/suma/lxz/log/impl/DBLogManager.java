package com.suma.lxz.log.impl;

import com.alibaba.fastjson.JSON;
import com.suma.lxz.log.ILogManager;
import com.suma.lxz.utils.LogAdmModel;
import org.springframework.stereotype.Service;

/**
 * @Author: luxinzong
 * @Date: 2018/11/23
 * @description
 */
@Service
public class DBLogManager implements ILogManager {
    @Override
    public void dealLog(LogAdmModel logAdmModel) {
        System.out.println("将日志存入数据库，日志内容如下："+ JSON.toJSONString(logAdmModel));
    }
}
