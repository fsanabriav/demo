package com.api.mutanthuman.infrastructure.drivenadapters.jpa;

import org.springframework.data.repository.CrudRepository;

public interface IStatDnaDataRepository extends CrudRepository<AnalyzedDnaData, String> {

}
