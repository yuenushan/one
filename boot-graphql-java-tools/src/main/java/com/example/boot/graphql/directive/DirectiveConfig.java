package com.example.boot.graphql.directive;

import com.oembedler.moon.graphql.boot.SchemaDirective;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectiveConfig {
    @Bean
    public SchemaDirective authorisationDirective(AuthorisationDirectiveWiring directiveWiring) {
        return new SchemaDirective("auth", directiveWiring);
    }
}
