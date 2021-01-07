package com.venns.service;

import com.venns.vo.BlogLikedCount;
import com.venns.vo.BlogViewCount;

import java.util.List;

public interface RedisService {


    /**
     * 点赞 ---- 状态为1
     */
    void saveLiked2Redis(String likedUserId, long likedBlogId);

    /**
     * 取消点赞  ---- 状态为0
     */
    void unlikeFromRedis(String likedUserId, long likeBlogId);

    /**
     * 从Redis中删除一条点赞数据
     */
    void deleteLikedFromRedis(String likedUserId, long likeBlogId);

    /**
     * 该博客的点赞数加1
     */
    void incrementLikedCount(long likeBlogId);

    /**
     * 该博客的点赞数减1
     */
    void decrementLikedCount(long likeBlogId);


    List<BlogLikedCount> getLikedCountFromRedis();

    List<BlogViewCount> getViewCountFromRedis();
}
