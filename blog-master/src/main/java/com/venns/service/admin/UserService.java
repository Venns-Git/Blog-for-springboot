package com.venns.service.admin;

import com.venns.po.User;

/**
 * @author kuls
 * @Desc kuls
 * @date 2020/5/4 5:27 下午
 */

public interface UserService {

    /*
    检查用户名和密码
     */
    User checkUser(String name, String password);
}
