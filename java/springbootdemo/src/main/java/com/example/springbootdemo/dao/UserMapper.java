package com.example.springbootdemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository 加不加无所谓
@Mapper
public interface UserMapper {
    public String getUsername(Integer id);
}
