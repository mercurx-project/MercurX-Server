package com.mercurx.tradingplatform.service;

import com.mercurx.tradingplatform.model.Metrics;

import java.util.List;

public interface MetricsService {
    Metrics getCaseById(long id);
    int createCase(Metrics task);
    Metrics updateCase(Metrics task);
    void deleteCase(Long id);
    List<Metrics> getCaseList();
}
