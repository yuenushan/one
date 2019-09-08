package com.example.boot.graphql.dataloader;

import com.example.boot.graphql.entity.Regimen;
import com.example.boot.graphql.mapper.RegimenMapper;
import com.example.boot.graphql.mapper.mo.RegimenWithDrugMO;
import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@Component
public class DrugToRegimenDataLoader extends DataLoader<Integer, List<Regimen>> {

    @Autowired
    public DrugToRegimenDataLoader(RegimenMapper regimenMapper, DataLoaderOptions options) {
        this(options, regimenMapper);
    }

    public DrugToRegimenDataLoader(DataLoaderOptions options, RegimenMapper regimenMapper) {
        super(new BatchLoader<Integer, List<Regimen>>() {
            @Override
            public CompletionStage<List<List<Regimen>>> load(List<Integer> drugIds) {
                List<RegimenWithDrugMO> regimenWithDrugMOs = regimenMapper.findByDrugIds(drugIds);
                Map<Integer, List<RegimenWithDrugMO>> regimenWithDrugMOMap = new HashMap<>();
                for (RegimenWithDrugMO regimenWithDrugMO: regimenWithDrugMOs) {
                    if (!regimenWithDrugMOMap.containsKey(regimenWithDrugMO.getDrugId())) {
                        regimenWithDrugMOMap.put(regimenWithDrugMO.getDrugId(), new LinkedList<>());
                    }
                    regimenWithDrugMOMap.get(regimenWithDrugMO.getDrugId()).add(regimenWithDrugMO);
                }
                List<List<Regimen>> result = new LinkedList<>();
                for (Integer drugId: drugIds) {
                    List<Regimen> regimenList = regimenWithDrugMOMap.getOrDefault(drugId, Collections.emptyList()).stream().map(regimenWithDrugMO -> {
                        Regimen regimen = new Regimen();
                        regimen.setName(regimenWithDrugMO.getName());
                        regimen.setId(regimenWithDrugMO.getId());
                        return regimen;
                    }).collect(Collectors.toList());
                    result.add(regimenList);
                }
                return CompletableFuture.completedFuture(result);
            }
        }, options);
    }
}
