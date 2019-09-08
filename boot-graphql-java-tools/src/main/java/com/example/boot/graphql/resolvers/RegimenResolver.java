package com.example.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.boot.graphql.entity.Drug;
import com.example.boot.graphql.entity.Regimen;
import com.example.boot.graphql.mapper.DrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegimenResolver implements GraphQLResolver<Regimen> {

    @Autowired
    private DrugMapper drugMapper;

    public List<Drug> getDrugs(Regimen regimen) {
        Integer regimenId = regimen.getId();
        return drugMapper.findByRegimenId(regimenId);
    }
}
