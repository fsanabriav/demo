package com.api.mutantapi.domain.usecase.validation;

import com.api.mutanthuman.domain.exception.InvalidCharacterException;
import com.api.mutanthuman.domain.exception.MalformedException;
import com.api.mutanthuman.domain.usecase.validation.ValidationUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationUseCaseTest {

    private ValidationUseCase validationUseCase =  new ValidationUseCase();

    @Test
    public void shouldBeValidSequenceTest(){
        String[]  correctSequence = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        validationUseCase.validateDNA(correctSequence);
    }

    @Test
    public void shouldBeMalformedExceptionBecauseNotIsSquareMatrixTest(){
        String[]  sequenceWithInvalidCharacters = {"CAGTGC","CAGTGC","TTATTT","AGACGG","GCGTCAS","TCACTG"};

        Assertions.assertThrows(MalformedException.class, () -> {
            validationUseCase.validateDNA(sequenceWithInvalidCharacters);
        });
    }

    @Test
    public void shouldBeInvalidCharacterExceptionTest(){
        String[]  sequence = {"ATGCGA","CAGTGC","TTATGT","asdsdd","CCCCTA","TCACTG"};

        Assertions.assertThrows(InvalidCharacterException.class, () -> {
            validationUseCase.validateDNA(sequence);
        });
    }
}
