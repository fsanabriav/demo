package com.api.mutanthuman.infrastructure.drivenadapters.jpa;

import com.api.mutanthuman.domain.model.analysisdna.AnalyzedDna;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * Esta clase es la implementacion del gateway definido en el dominio
 */

@Repository
public class AnalysisDnaRepositoryAdapter {

    @Autowired
    private IStatDnaDataRepository statDnaDataRepository;

    @Autowired
    private ObjectMapper mapper;

    /**
     * Actualiza o inserta el DNA analizado, incrementando en 1 las veces analizadas
     * @param analyzedDna
     */
    public void save(AnalyzedDna analyzedDna) {
        AnalyzedDnaData analyzedDnaDataToSave  = mapper.map(analyzedDna, AnalyzedDnaData.class);
        AnalyzedDnaData analyzedDnaDataFound = statDnaDataRepository.findById(analyzedDna.getDna()).orElse(null);
        if(Objects.nonNull(analyzedDnaDataFound)){
            analyzedDnaDataToSave.setAmount(analyzedDnaDataFound.getAmount() + 1);
        } else {
            analyzedDnaDataToSave.setAmount(1d);
        }
        statDnaDataRepository.save(analyzedDnaDataToSave);
    }

}
