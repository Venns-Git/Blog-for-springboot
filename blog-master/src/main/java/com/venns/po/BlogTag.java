package com.venns.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogTag {

    private Long id;

    private Long blog_id;

    private Integer tags_id;

}
