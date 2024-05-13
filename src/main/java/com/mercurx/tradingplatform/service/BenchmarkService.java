package com.mercurx.tradingplatform.service;

import com.mercurx.tradingplatform.model.Benchmark;

import java.util.List;

public interface BenchmarkService {

    Benchmark getBenchMarkScenarioById(long id);
    int createBenchmarkScenario(Benchmark task);
    Benchmark updateDocument(Benchmark task);
    void deleteDocument(Long id);
    List<Benchmark> getDocumentList();
}
