package com.api.mutanthuman.infrastructure.entrypoints.controller.stat;

import lombok.Data;

@Data
public class StatDnaAnalizedDTO {
    private Double countHumanDna;
    private Double countMutantDna;
    private Double ratio;
}
