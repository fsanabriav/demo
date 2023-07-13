package com.api.mutanthuman.domain.model.analysisdna.gateway;

import com.api.mutanthuman.domain.model.analysisdna.StatDnaAnalyzed;

/**
 * Interface  puerta de entrada para las capas. Su implementacion está en la capa exterior
 * Obtiene las estadisticas
 */
public interface IStatDnaRepository {
    StatDnaAnalyzed getStatsDna();
}
