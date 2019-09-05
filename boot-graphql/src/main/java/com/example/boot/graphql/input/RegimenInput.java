package com.example.boot.graphql.input;

import java.util.List;

public class RegimenInput {
    private String name;
    private List<String> drugNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDrugNames() {
        return drugNames;
    }

    public void setDrugNames(List<String> drugNames) {
        this.drugNames = drugNames;
    }
}
