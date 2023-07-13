package com.api.mutanthuman.infrastructure.config.messagebroker.analysisdna;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Objeto para mapear el envio y la recepcion de los mensajes de la cola
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnalisysDnaMessage {
    private String dna;
    private boolean isMutant;
    private Double amount;
}
