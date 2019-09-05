package com.example.boot.graphql.mapper;

import com.example.boot.graphql.entity.RegimenDrugRel;
import org.springframework.stereotype.Repository;

@Repository
public interface RegimenDrugRelMapper {
    Integer save(RegimenDrugRel regimenDrugRel);
}
