package com.venns.mapper;

import com.venns.po.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Mapper
@Repository
public interface TypeMapper {

    @Transactional
    int save(Type type);

    @Transactional
    Type getType(Long id);

    @Transactional
    Type getTypeByName(@Param("name") String name);

    @Transactional
    @Select("select * from t_type")
    List<Type> listType();

    @Transactional
    int updateType(Type type);

    @Transactional
    int deleteType(Long id);
}
