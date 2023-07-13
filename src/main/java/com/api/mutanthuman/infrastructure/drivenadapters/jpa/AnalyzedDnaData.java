package com.api.mutanthuman.infrastructure.drivenadapters.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TDNA_ANALYZED")
public class AnalyzedDnaData implements Serializable {

    @Id
    private String dna;
    @Column(name = "ismutant")
    private boolean isMutant;
    private Double amount;

}
