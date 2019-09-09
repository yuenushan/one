package com.example.boot.graphqljava.mapper;

import com.example.boot.graphqljava.entity.RegimenDrugRel;
import org.springframework.stereotype.Repository;

@Repository
public interface RegimenDrugRelMapper {
    Integer save(RegimenDrugRel regimenDrugRel);
}
