package com.example.boot.graphqljava.mapper;

import com.example.boot.graphqljava.entity.Regimen;
import com.example.boot.graphqljava.mapper.mo.RegimenWithDrugMO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegimenMapper {
    Integer save(Regimen regimen);
    Regimen findByName(String name);
    List<Regimen> findByDrugId(Integer drugId);
    List<RegimenWithDrugMO> findByDrugIds(@Param("drugIds") List<Integer> drugIds);
    List<Regimen> findAll();
}
