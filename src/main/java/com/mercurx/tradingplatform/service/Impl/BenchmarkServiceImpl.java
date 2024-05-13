package com.mercurx.tradingplatform.service.Impl;

import com.mercurx.tradingplatform.dao.HibernateDaoFactory;
import com.mercurx.tradingplatform.model.Benchmark;
import com.mercurx.tradingplatform.service.BenchmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchmarkServiceImpl implements BenchmarkService {

    @Autowired
    private HibernateDaoFactory hibernateDaoFactory;
    @Override
    public Benchmark getBenchMarkScenarioById(long id) {
        return this.hibernateDaoFactory.getBenchmarkDao().getBenchmarkDetails(id);
    }

    @Override
    public int createBenchmarkScenario(Benchmark benchmark) {
        return this.hibernateDaoFactory.getBenchmarkDao().addBenchmarkReport(benchmark);
    }

    @Override
    public Benchmark updateDocument(Benchmark benchmark) {
        return null;
    }

    @Override
    public void deleteDocument(Long id) {

    }

    @Override
    public List<Benchmark> getDocumentList() {
        return null;
    }
}
