package com.api.mutanthuman.infrastructure.drivenadapters.jpa;

import com.api.mutanthuman.domain.model.analysisdna.StatDnaAnalized;
import com.api.mutanthuman.domain.model.analysisdna.gateway.IStatDnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatDnaRepositoryAdapter implements IStatDnaRepository {

    @Autowired
    private IStatDnaDataRepository statDnaDataRepository;

    /**
     * Consulta las estadisticas de los ADNs analizado
     * @return
     */
    @Override
    public StatDnaAnalized getStatsDna() {
        List<AnalyzedDnaData> dnasAnalized = (List<AnalyzedDnaData>) statDnaDataRepository.findAll();
        Double countHumanDna = countHuman(dnasAnalized);
        Double countMutantDna = countMutant(dnasAnalized);

        return StatDnaAnalized.builder()
                .countHumanDna(countHumanDna)
                .countMutantDna(countMutantDna)
                .ratio(countMutantDna/countHumanDna)
                .build();
    }

    /**
     * Calcula la cantidad total de ADN analizados
     * @param dnasAnalized
     * @return
     */
    private Double countHuman(List<AnalyzedDnaData> dnasAnalized) {
        return dnasAnalized.stream()
                .filter(dna -> !dna.isMutant())
                .map(value -> value.getAmount())
                .reduce(0d, Double::sum);
    }

    /**
     * Calcula la cantidad de ADNs analizados que son mutantes
     * @param dnasAnalized
     * @return
     */
    private Double countMutant(List<AnalyzedDnaData> dnasAnalized) {
        return dnasAnalized.stream()
                .filter(dna -> dna.isMutant())
                .map(value -> value.getAmount())
                .reduce(0d, Double::sum);
    }

}
