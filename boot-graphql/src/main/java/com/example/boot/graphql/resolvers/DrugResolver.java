package com.example.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.boot.graphql.entity.Drug;
import com.example.boot.graphql.entity.Regimen;
import com.example.boot.graphql.mapper.RegimenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrugResolver implements GraphQLResolver<Drug> {

    @Autowired
    private RegimenMapper regimenMapper;

    public List<Regimen> getRegimens(Drug drug) {
        Integer drugId = drug.getId();
        return regimenMapper.findByDrugId(drugId);
    }
}
