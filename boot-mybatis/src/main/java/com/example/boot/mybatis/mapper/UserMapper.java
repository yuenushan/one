package com.example.boot.mybatis.mapper;

import com.example.boot.mybatis.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User find(Integer id);
}
