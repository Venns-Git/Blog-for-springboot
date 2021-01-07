package com.venns;

import com.venns.service.CommentService;
import com.venns.service.admin.BlogService;
import com.venns.service.admin.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringblogApplicationTests {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RedisTemplate<String, Object> template;

    @Test
    void contextLoads() {
        ValueOperations<String, Object> redisString = template.opsForValue();
        redisString.set("kuls", "hello,kuls");
//        template.opsForHash().put();

        String kuls = (String) redisString.get("kuls");
        System.out.println(kuls);

    }


}
