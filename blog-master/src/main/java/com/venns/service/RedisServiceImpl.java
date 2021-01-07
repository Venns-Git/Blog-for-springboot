package com.venns.service;

import com.venns.util.RedisUtils;
import com.venns.vo.BlogLikedCount;
import com.venns.vo.BlogViewCount;
import com.venns.vo.LikedStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public void saveLiked2Redis(String likedUserId, long likedBlogId) {
        String key = RedisUtils.getLikedKey(likedUserId, likedBlogId);

        redisTemplate.opsForHash().put(RedisUtils.MAP_KEY_USER_LIKED, key, LikedStatusEnum.LIKE.getCode());

    }

    @Override
    public void unlikeFromRedis(String likedUserId, long likeBlogId) {
        String key = RedisUtils.getLikedKey(likedUserId, likeBlogId);
        redisTemplate.opsForHash().put(RedisUtils.MAP_KEY_USER_LIKED, key, LikedStatusEnum.UNLIKE.getCode());


    }

    @Override
    public void deleteLikedFromRedis(String likedUserId, long likeBlogId) {
        String key = RedisUtils.getLikedKey(likedUserId, likeBlogId);
        redisTemplate.opsForHash().delete(RedisUtils.MAP_KEY_USER_LIKED, key);

    }

    @Override
    public void incrementLikedCount(long likeBlogId) {
        redisTemplate.opsForHash().increment(RedisUtils.MAP_KEY_USER_LIKED_COUNT, likeBlogId, 1);
    }

    @Override
    public void decrementLikedCount(long likeBlogId) {
        redisTemplate.opsForHash().increment(RedisUtils.MAP_KEY_USER_LIKED_COUNT, likeBlogId, -1);
    }


    @Override
    public List<BlogLikedCount> getLikedCountFromRedis() {
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan(RedisUtils.MAP_KEY_USER_LIKED_COUNT, ScanOptions.NONE);
        List<BlogLikedCount> list = new ArrayList<>();

        while (cursor.hasNext()) {

            Map.Entry<Object, Object> map = cursor.next();

            Integer key = (Integer) map.getKey();
            BlogLikedCount blogLikedCount = new BlogLikedCount(key, (Integer) map.getValue());

            list.add(blogLikedCount);

            //删除这条记录
            redisTemplate.opsForHash().delete(RedisUtils.MAP_KEY_USER_LIKED_COUNT, key);
        }
        return list;
    }

    @Override
    public List<BlogViewCount> getViewCountFromRedis() {
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan(RedisUtils.MAP_KEY_USER_VIEW_COUNT, ScanOptions.NONE);
        List<BlogViewCount> list = new ArrayList<>();

        while (cursor.hasNext()) {

            Map.Entry<Object, Object> map = cursor.next();

            Integer key = (Integer) map.getKey();
            BlogViewCount blogViewCount = new BlogViewCount(key, (Integer) map.getValue());

            list.add(blogViewCount);

            //删除这条记录
            redisTemplate.opsForHash().delete(RedisUtils.MAP_KEY_USER_VIEW_COUNT, key);
        }
        return list;
    }
}






















