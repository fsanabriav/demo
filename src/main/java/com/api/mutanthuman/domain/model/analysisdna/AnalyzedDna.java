package com.api.mutanthuman.domain.model.analysisdna;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzedDna {
    private String dna;
    private boolean isMutant;
    private Double amount;
}
