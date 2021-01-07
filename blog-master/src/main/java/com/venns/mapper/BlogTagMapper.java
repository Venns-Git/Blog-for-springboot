package com.venns.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface BlogTagMapper {

    int insertBlogTag(@Param("blogId") Long blogId, @Param("tagId") Long tagId);

    int delete(@Param("blogId") Long blogId);

    List<Long> selectByBlogId(@Param("blogId") long blogId);
}
