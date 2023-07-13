package com.api.mutanthuman.domain.strategy.strategyspecific;

import com.api.mutanthuman.domain.common.sequence.SequenceUtil;
import com.api.mutanthuman.domain.strategy.ISearchStrategy;

import java.util.Arrays;

/**
 * Implementacion del patron Strategy para buscar secuencias de mutantes en
 * las horizontales
 */
public class SearchStrategyHotizontal implements ISearchStrategy {
    @Override
    public long countSequencesMuntantInDna(String[] sequencesDNA) {
        return SequenceUtil.countValidSequences(Arrays.asList(sequencesDNA));
    }

}
