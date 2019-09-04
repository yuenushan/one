package com.example.boot.graphql.mapper;

import com.example.boot.graphql.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User find(Integer id);
}
