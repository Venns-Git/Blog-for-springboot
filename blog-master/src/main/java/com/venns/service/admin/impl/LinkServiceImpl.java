package com.venns.service.admin.impl;

import com.venns.mapper.LinkMapper;
import com.venns.po.Link;
import com.venns.service.admin.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;


    @Override
    public List<Link> listAll() {
        return linkMapper.listAll();
    }

    @Override
    public List<Link> listAllOnFront() {
        return linkMapper.listAllOnFront();
    }

    @Override
    public int addLink(Link link) {
        return linkMapper.addLink(link);
    }

    @Override
    public int updateLink(Link link) {
        return linkMapper.updateLink(link);
    }

    @Override
    public Link getLinkByID(int id) {
        return linkMapper.getLinkByID(id);
    }


    @Override
    public int deleteLink(int id) {
        return linkMapper.deleteLink(id);
    }
}
