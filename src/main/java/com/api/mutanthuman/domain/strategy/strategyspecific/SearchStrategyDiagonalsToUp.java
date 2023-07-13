package com.api.mutanthuman.domain.strategy.strategyspecific;

import com.api.mutanthuman.domain.common.sequence.SequenceUtil;
import com.api.mutanthuman.domain.strategy.ISearchStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion del patron Strategy para buscar secuencias de mutantes en
 * diagonales hacia arriba
 */
public class SearchStrategyDiagonalsToUp implements ISearchStrategy {
    @Override
    public long countSequencesMuntantInDna(String[] sequencesDNA) {
        List<String> diagonalsToUp = buildDiagonalSequencesToUp(sequencesDNA);
        return SequenceUtil.countValidSequences(diagonalsToUp);
    }

    /**
     * Devuelve una lista  con las diagonales hacia arriba
     * @param sequencesDNA
     * @return
     */
    private List<String> buildDiagonalSequencesToUp(String[] sequencesDNA) {
        List<String> diagonalsToUp = new ArrayList<>();
        for (int i = 0; i < sequencesDNA.length; i++) {
            StringBuilder lowerSequence = new StringBuilder();
            StringBuilder upperSequence = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                upperSequence.append(sequencesDNA[i - j].charAt(j));
                lowerSequence.append(sequencesDNA[sequencesDNA.length - j - 1].charAt(sequencesDNA.length - 1 - i + j));
            }
            diagonalsToUp.addAll(SequenceUtil.filterDiagonalsBuilt(lowerSequence.toString(), upperSequence.toString() , sequencesDNA.length));
        }
        return diagonalsToUp;
    }
}
