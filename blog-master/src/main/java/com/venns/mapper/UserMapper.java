package com.venns.mapper;

import com.venns.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


@Mapper
@Repository
public interface UserMapper {

    User userCheck(@PathVariable String username, @PathVariable String password);
}
