package com.venns.controller.front;

import com.venns.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogLikeController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/clickLike/{id}")
    @ResponseBody
    public String clickLike(@PathVariable long id) {

        redisService.incrementLikedCount(id);

        return "success";
    }

}
