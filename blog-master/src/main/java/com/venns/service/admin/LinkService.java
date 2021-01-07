package com.venns.service.admin;

import com.venns.po.Link;


import java.util.List;

/**
 * @author kuls
 * @Desc kuls
 * @date 2020/5/26 20:39
 */
public interface LinkService {


    // 返回给后台

    List<Link> listAll();

    //返回前端显示

    List<Link> listAllOnFront();

    //申请友链
    int addLink(Link link);


    int updateLink(Link link);

    Link getLinkByID(int id);

    int deleteLink(int id);
}
