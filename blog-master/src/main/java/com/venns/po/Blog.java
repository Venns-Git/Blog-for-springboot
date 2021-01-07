package com.venns.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private Long id;
    private String title;

    private String content;
    private String firstPicture;
    private String flag;
    private Integer view;
    private Integer likes;
    private String description;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private Date updateTime;


    private Type type;

    private List<Tag> tages;
    //tagIds不会进入数据库
    private String tagIds;

    private User user;

    private List<Comment> comments;


}
