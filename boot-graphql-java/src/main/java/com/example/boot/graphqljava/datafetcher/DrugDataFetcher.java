package com.example.boot.graphqljava.datafetcher;

import com.example.boot.graphqljava.entity.Drug;
import com.example.boot.graphqljava.entity.Regimen;
import com.example.boot.graphqljava.mapper.DrugMapper;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrugDataFetcher {

    @Autowired
    private DrugMapper drugMapper;

    public DataFetcher<List<Drug>> getDrugs() {
        return environment -> {
            if (environment.getSource() instanceof Regimen) {
                return getDrugsByRegimenId(((Regimen) environment.getSource()).getId());
            }
            return drugMapper.findAll();
        };
    }

    public List<Drug> getDrugsByRegimenId(Integer regimenId) {
        return drugMapper.findByRegimenId(regimenId);
    }

}
