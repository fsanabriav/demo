package com.api.mutanthuman.domain.usecase.stat;

import com.api.mutanthuman.domain.model.analysisdna.StatDnaAnalyzed;
import com.api.mutanthuman.domain.model.analysisdna.gateway.IStatDnaRepository;

/**
 * Caso de uso que se encarga de consultar las estadisticas de los ADNs evaluados
 */
public class StatUseCase {

    private IStatDnaRepository analysisDnaRepository;

    public StatUseCase(IStatDnaRepository analysisDnaRepository) {
        this.analysisDnaRepository = analysisDnaRepository;
    }

    public StatDnaAnalyzed getStatsDna() {
        return analysisDnaRepository.getStatsDna();
    }
}
