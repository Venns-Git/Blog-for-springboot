package com.venns.service;

import com.venns.po.Comment;

import java.util.List;


public interface CommentService {


    List<Comment> listComments(Long blogId);

    List<Comment> listAllComments();

    List<Comment> listAdminComments();

    int saveComments(Comment comment);

    int deleteComments(Long id);
}
