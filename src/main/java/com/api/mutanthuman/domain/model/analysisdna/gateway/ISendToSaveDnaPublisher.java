package com.api.mutanthuman.domain.model.analysisdna.gateway;

import com.api.mutanthuman.domain.model.analysisdna.AnalyzedDna;

/**
 * Interface  puerta de entrada para las capas. Su implementacion está en la capa exterior
 * Se usa parar enviar a guartar el ADN analizado
 */
public interface ISendToSaveDnaPublisher {
    void sendMessageToSave(AnalyzedDna analyzedDna);
}
