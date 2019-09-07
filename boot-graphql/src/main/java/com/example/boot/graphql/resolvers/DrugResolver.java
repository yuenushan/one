package com.example.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.boot.graphql.dataloader.DrugToRegimenDataLoader;
import com.example.boot.graphql.entity.Drug;
import com.example.boot.graphql.entity.Regimen;
import com.example.boot.graphql.mapper.RegimenMapper;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class DrugResolver implements GraphQLResolver<Drug> {

//    @Autowired
//    private RegimenMapper regimenMapper;
//
//    public List<Regimen> getRegimens(Drug drug) {
//        Integer drugId = drug.getId();
//        return regimenMapper.findByDrugId(drugId);
//    }

    @Autowired
    private DrugToRegimenDataLoader drugToRegimenDataLoader;

    public CompletableFuture<List<Regimen>> getRegimens(Drug drug, DataFetchingEnvironment environment) {
        DataLoader<Integer, List<Regimen>> dataLoader = environment.getDataLoader("regimens");
        return dataLoader.load(drug.getId());
//        try {
//            return drugToRegimenDataLoader.load(drug.getId());
//        } catch (Exception e) {
//            System.out.println(e);
//            throw e;
//        }
    }
}
