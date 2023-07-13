package com.api.mutanthuman.infrastructure.drivenadapters.messagebroker.analysisdna;

import com.api.mutanthuman.domain.model.analysisdna.AnalyzedDna;
import com.api.mutanthuman.domain.model.analysisdna.gateway.ISendToSaveDnaPublisher;
import com.api.mutanthuman.infrastructure.config.messagebroker.analysisdna.AnalisysDnaMessage;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Publicados de la cola parar guardar los ADN analizado.
 * Se propone el uso de colas para asegurar el guardado de todos los mensaje
 * en caso de picos muy altos de uso.
 */
@Component
public class SaveDnaPublisher implements ISendToSaveDnaPublisher {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void sendMessageToSave(AnalyzedDna analyzedDna) {
        queueMessagingTemplate.convertAndSend(endpoint, mapper.map(analyzedDna, AnalisysDnaMessage.class));
    }
}
