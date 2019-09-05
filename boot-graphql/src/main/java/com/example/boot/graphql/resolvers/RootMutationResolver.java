package com.example.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.boot.graphql.entity.Drug;
import com.example.boot.graphql.entity.Regimen;
import com.example.boot.graphql.entity.RegimenDrugRel;
import com.example.boot.graphql.input.RegimenInput;
import com.example.boot.graphql.mapper.DrugMapper;
import com.example.boot.graphql.mapper.RegimenDrugRelMapper;
import com.example.boot.graphql.mapper.RegimenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RootMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private DrugMapper drugMapper;
    @Autowired
    private RegimenMapper regimenMapper;
    @Autowired
    private RegimenDrugRelMapper regimenDrugRelMapper;

    public Drug createDrug(String name) {
        Drug drug = new Drug();
        drug.setName(name);
        drugMapper.save(drug);
        return drug;
    }

    public Regimen createRegimen(RegimenInput regimenInput) {
        List<Integer> drugIds = new ArrayList<>(regimenInput.getDrugNames().size());
        for(String drugName: regimenInput.getDrugNames()) {
            Drug drug = drugMapper.findByName(drugName);
            if (drug == null) {
                throw new RuntimeException("无效的drug");
            } else {
                drugIds.add(drug.getId());
            }
        }
        Regimen regimenDomain = new Regimen();
        regimenDomain.setName(regimenInput.getName());
        regimenMapper.save(regimenDomain);
        for (Integer drugId: drugIds) {
            RegimenDrugRel regimenDrugRel = new RegimenDrugRel();
            regimenDrugRel.setRegimenId(regimenDomain.getId());
            regimenDrugRel.setDrugId(drugId);
            regimenDrugRelMapper.save(regimenDrugRel);
        }
        return regimenDomain;
    }
}
