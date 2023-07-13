package com.api.mutanthuman.domain.common;

import java.util.Arrays;
import java.util.List;

public class Constants {
    /**
     * Expresion regular con los caracteres validos en las secuencias de ADN
     */
    public static final String REGEX_DNA_ALLOWED_CHARACTERS = "[ACGT]+";

    /**
     * Cantidad minima de secuancias validas que debe tener el ADN para se mutante
     */
    public static final long MIN_SEQUENCES_TO_BE_MUTANT = 2;

    /**
     * Secuencias de 4 caracteres validos para  buscar en el ADN
     */
    public static final List<String> VALID_SEQUENCES_TO_BE_MUTANT = Arrays.asList("AAAA", "TTTT", "CCCC", "GGGG");
}
