package com.api.mutanthuman.application;

import com.api.mutanthuman.domain.model.analysisdna.gateway.ISendToSaveDnaPublisher;
import com.api.mutanthuman.domain.model.analysisdna.gateway.IStatDnaRepository;
import com.api.mutanthuman.domain.usecase.mutant.MutantUseCase;
import com.api.mutanthuman.domain.usecase.stat.StatUseCase;
import com.api.mutanthuman.domain.strategy.StrategyFactory;
import com.api.mutanthuman.domain.usecase.validation.ValidationUseCase;
import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase usada para crear beans de los componente del dominio. Con el objetivo de evitar
 * el uso del framework en la capa de dominio
 */
@Configuration
public class UseCaseConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapperImp();
    }

    @Bean
    public MutantUseCase mutantUseCase(ValidationUseCase validationUseCase, StrategyFactory strategyFactory, ISendToSaveDnaPublisher sentToSaveDnaRepository) {
        return new MutantUseCase(validationUseCase, strategyFactory, sentToSaveDnaRepository);
    }

    @Bean
    public ValidationUseCase validationUseCase(){
        return new ValidationUseCase();
    }

    @Bean
    public StatUseCase statUseCase(IStatDnaRepository statDnaRepository) {
        return new StatUseCase(statDnaRepository);
    }

    @Bean
    public StrategyFactory strategyFactory(){
        return new StrategyFactory();
    }

}
