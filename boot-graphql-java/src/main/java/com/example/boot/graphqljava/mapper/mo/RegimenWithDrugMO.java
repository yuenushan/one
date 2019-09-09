package com.example.boot.graphqljava.mapper.mo;

import com.example.boot.graphqljava.entity.Regimen;

public class RegimenWithDrugMO extends Regimen {
    private Integer drugId;

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }
}
