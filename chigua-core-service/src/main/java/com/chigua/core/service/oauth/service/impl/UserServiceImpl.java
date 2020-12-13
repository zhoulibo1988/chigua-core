package com.chigua.core.service.oauth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chigua.core.mybatis.base.BaseServiceImpl;
import com.chigua.core.service.oauth.entity.UserInfo;
import com.chigua.core.service.oauth.mapper.UserMapper;
import com.chigua.core.service.oauth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassNameUserService
 * @Description
 * @Author Mr.Zhou
 * @Date2020/9/18 14:43
 * @Version V1.0
 **/
@Service
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserInfo> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserInfo getUserByName(String username) {
        QueryWrapper<UserInfo> userQueryWrapper=new QueryWrapper<>();
        UserInfo user=new UserInfo();
        user.setUsername(username);
        userQueryWrapper.setEntity(user);
        return userMapper.selectOne(userQueryWrapper);
    }

    @Override
    public UserInfo getLogin() {
        User userInfo=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo1=getUserByName(userInfo.getUsername());
        return userInfo1;
    }
}
