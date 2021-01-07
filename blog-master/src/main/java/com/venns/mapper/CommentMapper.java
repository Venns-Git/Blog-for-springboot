package com.venns.mapper;

import com.venns.po.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CommentMapper {

    List<Comment> listComments(@Param("blogId") Long blogId);


    List<Comment> listAllComments();

    List<Comment> listAdminComments();

    int saveComments(Comment comment);

    Comment getCommentByParentId(@Param("parentId") Long parentId);

    int deleteComments(@Param("id") Long id);
}
