package com.example.boot.graphql;

import com.example.boot.graphql.dataloader.DrugToRegimenDataLoader;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentation;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentationOptions;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
@MapperScan("com.example.boot.graphql.mapper")
public class BootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootGraphqlApplication.class, args);
    }

    @Bean
    DataLoaderRegistry dataLoaderRegistry(List<DataLoader<?, ?>> loaderList) {
        DataLoaderRegistry registry = new DataLoaderRegistry();
        for (DataLoader<?, ?> loader : loaderList) {
            registry.register(loader.getClass().getSimpleName(), loader);
        }
        return registry;
    }

    @Bean
    Instrumentation instrumentation(DataLoaderRegistry dataLoaderRegistry) {
//        DataLoaderDispatcherInstrumentationOptions options = DataLoaderDispatcherInstrumentationOptions
//                .newOptions().includeStatistics(true);
//        return new DataLoaderDispatcherInstrumentation(options);
        return new DataLoaderDispatcherInstrumentation(dataLoaderRegistry);
    }
}
