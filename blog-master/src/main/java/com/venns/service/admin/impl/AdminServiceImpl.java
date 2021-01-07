package com.venns.service.admin.impl;

import com.venns.mapper.AdminMapper;
import com.venns.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Long getBlogsCount() {
        return adminMapper.getBlogsCount();
    }

    @Override
    public Long getViewsSum() {
        return adminMapper.getViewsSum();
    }

    @Override
    public Long getCommentsCount() {
        return adminMapper.getCommentsCount();
    }
}
