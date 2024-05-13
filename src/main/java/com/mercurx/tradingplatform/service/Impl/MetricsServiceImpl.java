package com.mercurx.tradingplatform.service.Impl;

import com.mercurx.tradingplatform.dao.HibernateDaoFactory;
import com.mercurx.tradingplatform.model.Metrics;
import com.mercurx.tradingplatform.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MetricsServiceImpl implements MetricsService {

    @Autowired
    private HibernateDaoFactory hibernateDaoFactory;
    @Override
    public Metrics getCaseById(long id) {
        return this.hibernateDaoFactory.getMetricsDao().getMetricsByID(id);
    }

    @Override
    public int createCase(Metrics lcase) {
        return this.hibernateDaoFactory.getMetricsDao().saveMetricsData(lcase);
    }

    @Override
    public Metrics updateCase(Metrics metrics) {
        return null;
    }

    @Override
    public void deleteCase(Long id) {

    }

    @Override
    public List<Metrics> getCaseList() {
        return null;
    }
}
