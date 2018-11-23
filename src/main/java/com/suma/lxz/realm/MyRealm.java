package com.suma.lxz.realm;

import com.suma.lxz.pojo.User;
import com.suma.lxz.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luxinzong
 * @date 2018/10/31
 * @description 自定义realm。根据上面传下来的数据库查信息，查到返回一个SimpleAuthebticationInfo,查不到返回null
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("myrealm");
    }

    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //token是用户输入的
        //第一步从token中取出身份信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String password = "";
        Boolean remenber = usernamePasswordToken.isRememberMe();

        if (usernamePasswordToken.getPassword() != null) {
            password = new String(usernamePasswordToken.getPassword());
        }
        //从数据库查询密码
        User user = null;
        user.setUsername(username);
        user.setPassword(password);
        user = userService.select(user);
        //如果查询到返回认证信息AuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, this.getName());
        return simpleAuthenticationInfo;
    }

    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从prinvipals获取身份信息
        //将getPrimaryPrincipal方法转为真实的身份类型
        String userCode = (String) principalCollection.getPrimaryPrincipal();
        //根据身份信息获取权限信息
        //连接数据库
        //模拟从数据库获取到数据
        List<String> permissions = new ArrayList<>();
        permissions.add("user:create");//用户创建
        permissions.add("items:add");//商品添加权限

        //查询到权限数据，返回授权信息(要包括 上边的permissions)
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上边查询到的授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }


}
