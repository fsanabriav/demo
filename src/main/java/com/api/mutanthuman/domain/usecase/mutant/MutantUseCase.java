package com.api.mutanthuman.domain.usecase.mutant;

import com.api.mutanthuman.domain.common.Constants;
import com.api.mutanthuman.domain.model.analysisdna.AnalyzedDna;
import com.api.mutanthuman.domain.model.analysisdna.gateway.ISendToSaveDnaPublisher;
import com.api.mutanthuman.domain.strategy.ISearchStrategy;
import com.api.mutanthuman.domain.strategy.SearchStrategyType;
import com.api.mutanthuman.domain.strategy.StrategyFactory;
import com.api.mutanthuman.domain.usecase.validation.ValidationUseCase;

/**
 * Caso de uso que se encarga de validar las secuencias de ADN.
 */
public class MutantUseCase {

    private ValidationUseCase validationUseCase;

    private StrategyFactory strategyFactory;

    private ISendToSaveDnaPublisher sentToSaveDnaRepository;

    public MutantUseCase(ValidationUseCase validationUseCase, StrategyFactory strategyFactory, ISendToSaveDnaPublisher sentToSaveDnaRepository) {
        this.validationUseCase = validationUseCase;
        this.strategyFactory = strategyFactory;
        this.sentToSaveDnaRepository = sentToSaveDnaRepository;
    }

    /**
     * Retorna true si el ADN es de un mutante, de lo contrario retorna false
     * Es un mutante si hay mas de una secuencia de 4 letras iguales vertical, horizontal u oblicuamente (diagonalmente)
     * Si el numero de secuencias mutantes encontradas es mayor o igual  que el valor minimo, la funcion deja de evaluar las otras secuencias.
     * @param sequencesDNA
     * @return
     */
    public boolean isMutant(String[] sequencesDNA) {
        validationUseCase.validateDNA(sequencesDNA);
        boolean isMutant = isMutantDna(sequencesDNA);
        saveAnalyzedDna(sequencesDNA, isMutant);
        return isMutant;
    }

    private boolean isMutantDna(String[] sequencesDNA) {
        ISearchStrategy strategy;
        boolean isMutantDna = false;
        long validSequencesFound = 0;
        for (SearchStrategyType strategyType : SearchStrategyType.values()) {
            strategy = strategyFactory.getSearchStrategy(strategyType.name());
            validSequencesFound += strategy.countSequencesMutantInDna(sequencesDNA);
            if(validSequencesFound >= Constants.MIN_SEQUENCES_TO_BE_MUTANT) {
                isMutantDna = true;
                break;
            }
        }
        return isMutantDna;
    }

    /**
     * Envia a guardar el ADN analizado
     * @param sequencesDNA
     * @param isMutant
     */
    private void saveAnalyzedDna(String[] sequencesDNA, boolean isMutant) {
        sentToSaveDnaRepository.sendMessageToSave(AnalyzedDna.builder().
                dna(String.join("", sequencesDNA)).
                isMutant(isMutant)
                .build());
    }

}
