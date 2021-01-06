package com.venns.service.impl;

import com.venns.entity.User;
import com.venns.mapper.UserMapper;
import com.venns.service.UserService;
import com.venns.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public User login(String username, String password) {
        return userMapper.login(username, MD5Utils.code(password));
    }
}
