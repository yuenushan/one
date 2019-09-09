package com.example.boot.graphqljava.datafetcher;

import com.example.boot.graphqljava.entity.Drug;
import com.example.boot.graphqljava.entity.Regimen;
import com.example.boot.graphqljava.mapper.RegimenMapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegimenDataFetcher {

    @Autowired
    private RegimenMapper regimenMapper;

    public DataFetcher getRegimens() {
        return new DataFetcher<List<Regimen>>() {
            @Override
            public List<Regimen> get(DataFetchingEnvironment environment) throws Exception {
                Drug drug = environment.getSource();
                Integer drugId = drug.getId();
                return regimenMapper.findByDrugId(drugId);
            }
        };
    }
}
