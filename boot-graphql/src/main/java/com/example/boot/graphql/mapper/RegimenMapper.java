package com.example.boot.graphql.mapper;

import com.example.boot.graphql.entity.Regimen;
import com.example.boot.graphql.mapper.mo.RegimenWithDrugMO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegimenMapper {
    Integer save(Regimen regimen);
    Regimen findByName(String name);
    List<Regimen> findByDrugId(Integer drugId);
    List<RegimenWithDrugMO> findByDrugIds(List<Integer> drugIds);
    List<Regimen> findAll();
}
