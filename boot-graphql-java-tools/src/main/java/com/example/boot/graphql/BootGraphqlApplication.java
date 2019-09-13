package com.example.boot.graphql;

import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@MapperScan("com.example.boot.graphql.mapper")
public class BootGraphqlApplication {

    @Bean
    public Instrumentation tracingInstrumentation() {
        return new TracingInstrumentation();
    }

    public static void main(String[] args) {
        SpringApplication.run(BootGraphqlApplication.class, args);
    }

}
