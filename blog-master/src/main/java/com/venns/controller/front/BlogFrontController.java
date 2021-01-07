package com.venns.controller.front;

import com.venns.exception.BlogNotFoundException;
import com.venns.mapper.BlogTagMapper;
import com.venns.po.Blog;
import com.venns.service.admin.BlogService;
import com.venns.service.admin.LinkService;
import com.venns.service.admin.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class BlogFrontController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private LinkService linkService;

    /**
     * 显示指定博客详情信息
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping({"/blog/{id}"})
    public String blogDetail(
            @PathVariable long id,
            Model model) {

        Blog blog = blogService.getBlogOnfront(id);
        if (blog == null){
            throw new BlogNotFoundException("很抱歉，这篇博客不存在~");
        }
        blogService.incView(id);
        model.addAttribute("blog", blog);
        model.addAttribute("tags", tagService.listTag(blogTagMapper.selectByBlogId(id)));
        model.addAttribute("links", linkService.listAllOnFront());
        return "blog";
    }

}
