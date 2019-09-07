package com.example.boot.graphql;

import com.example.boot.graphql.dataloader.DrugToRegimenDataLoader;
import org.dataloader.DataLoaderRegistry;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@MapperScan("com.example.boot.graphql.mapper")
public class BootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootGraphqlApplication.class, args);
    }

    @Bean
    DataLoaderRegistry dataLoaderRegistry(DrugToRegimenDataLoader drugToRegimenDataLoader) {
        DataLoaderRegistry dataLoaderRegistry = new DataLoaderRegistry();
        dataLoaderRegistry.register("regimens", drugToRegimenDataLoader);
        return dataLoaderRegistry;
    }
}
