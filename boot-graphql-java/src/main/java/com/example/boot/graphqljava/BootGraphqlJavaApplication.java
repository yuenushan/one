package com.example.boot.graphqljava;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.boot.graphqljava.mapper")
public class BootGraphqlJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootGraphqlJavaApplication.class, args);
    }

}
