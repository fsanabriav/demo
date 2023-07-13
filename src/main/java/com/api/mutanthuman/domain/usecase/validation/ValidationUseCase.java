package com.api.mutanthuman.domain.usecase.validation;

import com.api.mutanthuman.domain.exception.InvalidCharacterException;
import com.api.mutanthuman.domain.exception.MalformedException;
import com.api.mutanthuman.domain.common.Constants;

import java.util.Arrays;
import java.util.Objects;

/**
 * Caso de uso que se encarga de realizar las validacion de forma sobre el ADN a evaluar
 * (Vacio, Matriz NxN,caracteres invalidos)
 */
public class ValidationUseCase {

    /**
     * Relizar las validaciones de tamania, matriz cuadrada y caracteres validos
     * @param  sequencesDNA con las secuenncias de ADN a evaluar
     */
    public void validateDNA(String[] sequencesDNA) {
        validateEmptyDNA(sequencesDNA);
        validateSquareMatrix(sequencesDNA);
        validateCharacters(sequencesDNA);
    }

    /**
     * Valida si el array es nulo o vacio
     * @param  sequencesDNA con las secuenncias de ADN a evaluar
     */

    private void validateEmptyDNA(String[] sequencesDNA) {
        if (Objects.isNull(sequencesDNA) || sequencesDNA.length == 0) {
            throw new MalformedException("No hay secuencias de ADN");
        }
    }

    /**
     * Valida si las secuencias estan formadas por caracteres validos
     * @param  sequencesDNA con las secuencias de ADN a evaluar
     */
    private void validateCharacters(String[] sequencesDNA) {

        boolean containInvalidCharacters = Arrays.stream(sequencesDNA)
                .anyMatch(sequence ->  !sequence.matches(Constants.REGEX_DNA_ALLOWED_CHARACTERS));

        if (containInvalidCharacters)
            throw new InvalidCharacterException("El ADN contiene caracteres inv\u00E1lidos");
    }

    /**
     * Valida si las secuencias conforman una matriz cuadrada
     * @param  sequencesDNA con las secuenncias de ADN a evaluar
     */
    private void validateSquareMatrix(String[] sequencesDNA) {
        int amountSequences = sequencesDNA.length;
        boolean isSquareMatrix = Arrays.stream(sequencesDNA)
                .anyMatch(sequence -> Objects.isNull(sequence) || sequence.length() != amountSequences);
        if (isSquareMatrix)
            throw new MalformedException("Las secuencias del ADN no constituyen una matriz cuadrada");
    }
}
