package com.example.boot.graphql.dataloader;

import org.dataloader.DataLoaderOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {
    @Bean
    public DataLoaderOptions dataLoaderOptions() {
        DataLoaderOptions options = new DataLoaderOptions();
        options.setCachingEnabled(false);
        return options;
    }
}
