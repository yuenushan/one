package com.example.boot.graphqljava.datafetcher;

import com.example.boot.graphqljava.entity.Drug;
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
        return environment -> drugMapper.findAll();
    }
}
