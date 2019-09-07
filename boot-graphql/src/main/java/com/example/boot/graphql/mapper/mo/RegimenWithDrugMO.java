package com.example.boot.graphql.mapper.mo;

import com.example.boot.graphql.entity.Regimen;

public class RegimenWithDrugMO extends Regimen {
    private Integer drugId;

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }
}
