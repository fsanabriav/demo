package com.api.mutanthuman.domain.model.analysisdna;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatDnaAnalized {
    private Double countHumanDna;
    private Double countMutantDna;
    private Double ratio;
}
