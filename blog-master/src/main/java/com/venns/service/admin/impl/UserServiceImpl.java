package com.venns.service.admin.impl;

import com.venns.mapper.UserMapper;
import com.venns.po.User;
import com.venns.service.admin.UserService;
import com.venns.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String name, String password) {
        User user = userMapper.userCheck(name, MD5Utils.code(password));

        return user;
    }
}
