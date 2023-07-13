package com.api.mutanthuman.infrastructure.entrypoints.messagebroker.analysisdna;

import com.api.mutanthuman.domain.model.analysisdna.AnalyzedDna;
import com.api.mutanthuman.infrastructure.config.messagebroker.analysisdna.AnalysisDnaMessage;
import com.api.mutanthuman.infrastructure.drivenadapters.jpa.AnalysisDnaRepositoryAdapter;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveDnaConsumer {

    @Autowired
    private AnalysisDnaRepositoryAdapter analysisDnaRepositoryAdapter;

    @Autowired
    private ObjectMapper mapper;

    @SqsListener(value = "dna_analized", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(AnalysisDnaMessage analysisDnaMessage) {
        analysisDnaRepositoryAdapter.save(mapper.map(analysisDnaMessage, AnalyzedDna.class));
    }
}
