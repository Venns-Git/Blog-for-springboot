package com.venns.controller.front;

import com.venns.po.Comment;
import com.venns.po.User;
import com.venns.service.CommentService;
import com.venns.service.admin.BlogService;
import com.venns.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;


    /**
     * 显示博客评论信息
     *
     * @param blogId
     * @param model
     * @return
     */
    @GetMapping("/comments/{blogId}")
    public String comment(@PathVariable Long blogId, Model model) {

        model.addAttribute("comments", commentService.listComments(blogId));
        return "blog :: commentList";
    }


    /**
     * 发表评论
     *
     * @param comment
     * @param session
     * @return
     */
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {
        Long id = comment.getBlog().getId();
        String email = comment.getEmail();

        comment.setBlog(blogService.getBlogByID(id));
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
//            http://q1.qlogo.cn/g?b=qq&nk=1839938674&s=100
//            comment.setNickname();
            comment.setAvatar("http://q1.qlogo.cn/g?b=qq&nk=" + StringUtils.getQQ(comment.getEmail()) + "&s=100");
        }

        commentService.saveComments(comment);

        return "redirect:/comments/" + id;
    }
}










