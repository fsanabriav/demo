package com.api.mutanthuman.domain.strategy.specificstrategy;

import com.api.mutanthuman.domain.common.sequence.SequenceUtil;
import com.api.mutanthuman.domain.strategy.ISearchStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion del patron Strategy para buscar secuencias de mutantes en
 * diagonales hacia abajo
 */
public class SearchStrategyDiagonalsToDown implements ISearchStrategy {

    @Override
    public long countSequencesMutantInDna(String[] sequencesDNA) {
        List<String> diagonalsToDown = buildDiagonalsToDown(sequencesDNA);
        return SequenceUtil.countValidSequences(diagonalsToDown);
    }

    /**
     * Metodo que construye las diagonales hacia abajo
     * @param sequencesDNA
     * @return
     */
    private List<String> buildDiagonalsToDown(String[] sequencesDNA) {
        List<String> diagonalsToDown = new ArrayList<>();
        for (int i = 0; i < sequencesDNA.length; i++) {
            StringBuilder lowerSequence = new StringBuilder();
            StringBuilder upperSequence = new StringBuilder();
            for (int j = 0; j < sequencesDNA.length - i ; j++) {
                lowerSequence.append(sequencesDNA[i+j].charAt(j));
                upperSequence.append(sequencesDNA[j].charAt(i+j));
            }
            diagonalsToDown.addAll(SequenceUtil.filterDiagonalsBuilt(lowerSequence.toString(), upperSequence.toString() , sequencesDNA.length));
        }
        return diagonalsToDown;
    }
}
