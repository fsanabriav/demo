package com.api.mutanthuman.domain.strategy;

/**
 * Interface del patron Strategy
 */
public interface ISearchStrategy {
    /**
     * Metodo que cuenta la cantidad de secuencias validas en el ADN
     * segun la estretegia usada
     * @param sequencesDNA
     * @return
     */
    long countSequencesMutantInDna(String[] sequencesDNA);
}
