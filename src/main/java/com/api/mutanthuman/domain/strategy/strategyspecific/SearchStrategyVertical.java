package com.api.mutanthuman.domain.strategy.strategyspecific;

import com.api.mutanthuman.domain.common.sequence.SequenceUtil;
import com.api.mutanthuman.domain.strategy.ISearchStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion del patron Strategy para buscar secuencias de mutantes en
 * las verticales
 */
public class SearchStrategyVertical implements ISearchStrategy {
    @Override
    public long countSequencesMuntantInDna(String[] sequencesDNA) {
        List<String> verticalSequences = buildVerticalSequences(sequencesDNA);
        return SequenceUtil.countValidSequences(verticalSequences);
    }

    /**
     * Devuelve una lista  con las sequiencias verticales
     * @param sequencesDNA
     * @return
     */
    private List<String> buildVerticalSequences(String[] sequencesDNA) {
        List<String> verticalSequences = new ArrayList<>();
        for (int i = 0; i < sequencesDNA.length; i++) {
            StringBuilder sequenceVertical = new StringBuilder();
            for (int j = 0; j < sequencesDNA.length; j++) {
                sequenceVertical.append(sequencesDNA[j].charAt(i));
            }
            verticalSequences.add(sequenceVertical.toString());
        }
        return verticalSequences;
    }

}
