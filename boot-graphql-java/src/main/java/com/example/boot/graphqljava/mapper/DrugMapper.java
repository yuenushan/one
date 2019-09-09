package com.example.boot.graphqljava.mapper;

import com.example.boot.graphqljava.entity.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugMapper {

    Integer save(Drug drug);

    Drug findByName(String name);

    List<Drug> findByRegimenId(Integer regimenId);

    List<Drug> findAll();
}
