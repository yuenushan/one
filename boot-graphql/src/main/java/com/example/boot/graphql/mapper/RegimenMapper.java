package com.example.boot.graphql.mapper;

import com.example.boot.graphql.entity.Regimen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegimenMapper {
    Integer save(Regimen regimen);
    Regimen findByName(String name);
    List<Regimen> findByDrugId(Integer drugId);
    List<Regimen> findAll();
}
