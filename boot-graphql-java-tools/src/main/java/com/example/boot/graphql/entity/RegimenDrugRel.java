package com.example.boot.graphql.entity;

public class RegimenDrugRel {
    private Integer id;
    private Integer regimenId;
    private Integer drugId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegimenId() {
        return regimenId;
    }

    public void setRegimenId(Integer regimenId) {
        this.regimenId = regimenId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }
}
