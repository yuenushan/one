package com.example.boot.graphql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.boot.graphql.mapper")
public class BootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootGraphqlApplication.class, args);
    }

}
