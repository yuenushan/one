package com.example.boot.graphqljava;

import com.example.boot.graphqljava.datafetcher.DrugDataFetcher;
import com.example.boot.graphqljava.datafetcher.HelloDataFetcher;
import com.example.boot.graphqljava.datafetcher.RegimenDataFetcher;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {
    private GraphQL graphQL;
    @Autowired
    private HelloDataFetcher helloDataFetcher;
    @Autowired
    private DrugDataFetcher drugDataFetcher;
    @Autowired
    private RegimenDataFetcher regimenDataFetcher;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        TypeDefinitionRegistry typeRegistry = parseTDR(scanGraphqlFiles());
        GraphQLSchema graphQLSchema =new SchemaGenerator().makeExecutableSchema(typeRegistry, buildWiring());
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private List<String> scanGraphqlFiles() throws FileNotFoundException {
        List<String> graphqlFiles = new LinkedList<>();
        File fileDir = ResourceUtils.getFile("classpath:");
        for (File file: fileDir.listFiles()) {
            if (file.getName().endsWith(".graphqls") || file.getName().endsWith(".graphql")) {
                graphqlFiles.add(file.getName());
            }
        }
        return graphqlFiles;
    }

    private TypeDefinitionRegistry parseTDR(List<String> schemas) throws IOException {
        TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
        SchemaParser schemaParser = new SchemaParser();
        for (String schema: schemas) {
            URL url = Resources.getResource(schema);
            String sdl = Resources.toString(url, Charsets.UTF_8);
            typeRegistry.merge(schemaParser.parse(sdl));
        }
        return typeRegistry;
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("hello", helloDataFetcher.hello())
                        .dataFetcher("drugs", drugDataFetcher.getDrugs())
                )
                .type(newTypeWiring("Drug")
                        .dataFetcher("regimens", regimenDataFetcher.getRegimens())
                ).type(newTypeWiring("Regimen")
                        .dataFetcher("drugs", drugDataFetcher.getDrugs())
                )
                .type(newTypeWiring("Mutation")
                        .dataFetcher("createDrug", drugDataFetcher.createDrug())
                )
                .build();
    }

}
