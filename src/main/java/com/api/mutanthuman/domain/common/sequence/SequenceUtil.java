package com.api.mutanthuman.domain.common.sequence;

import com.api.mutanthuman.domain.common.Constants;

import java.util.Arrays;
import java.util.List;

/**
 * Caso de uso que se encarga de manipular las posibles secuencias del ADN a evaluar
 */
public class SequenceUtil {

    /**
     * Retorna una lista de secuencias a agregar. Si la secuencia a agregar es la diagonal principal o secundaria,
     * solo se agrega una vez a la lista. De  lo contrario, se agregan las dos secuencias.
     * @param firstSequenceBuilt
     * @param secondSequenceBuilt
     * @param matrixSize
     * @return
     */
    public static List<String> filterDiagonalsBuilt(String firstSequenceBuilt, String secondSequenceBuilt, int matrixSize) {
        if(isMainOrSecondaryDiagonal(firstSequenceBuilt, matrixSize)) {
            return Arrays.asList(firstSequenceBuilt);
        } else {
            return Arrays.asList(firstSequenceBuilt,secondSequenceBuilt);
        }
    }

    /**
     * Cuenta las secuencias validas que se encuentran en lista de secuencias de ADN
     * @param sequencesDNA
     * @return
     */
    public static long countValidSequences(List<String> sequencesDNA) {
        long validSequences = 0;
        for (String validSequence : Constants.VALID_SEQUENCES_TO_BE_MUTANT) {
            validSequences += sequencesDNA.stream()
                    .filter(sequence -> sequence.contains(validSequence))
                    .count();
        }
        return validSequences;
    }

    /**
     * Retorna true si la secuencia a agregar es la diagonal principal o secundaria de la matriz. De lo contralio False
     * @param sequenceToAdd
     * @param matrixSize
     * @return
     */
    private static boolean isMainOrSecondaryDiagonal(String sequenceToAdd, int matrixSize) {
        return matrixSize == sequenceToAdd.length();
    }



}
