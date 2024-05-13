package com.mercurx.tradingplatform.dao;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class HibernateDaoFactory {

    private SessionFactory hibernateFactory;

    @Autowired
    public HibernateDaoFactory(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }



    private SessionFactory session;
    private BenchmarkDaoImpl documentDao;
    private MetricsDaoImpl lCaseDao;
    private TransactionDaoImpl taskDao;
    private UserDaoImpl userDao;
    public UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
            userDao.setSessionFactory(this.hibernateFactory);
        }
        return userDao;
    }

    public MetricsDaoImpl getMetricsDao() {
        if (lCaseDao == null) {
            lCaseDao = new MetricsDaoImpl();
            lCaseDao.setSessionFactory(this.hibernateFactory);
        }
        return lCaseDao;
    }
    public BenchmarkDaoImpl getBenchmarkDao() {
        if (documentDao == null) {
            documentDao = new BenchmarkDaoImpl();
            documentDao.setSessionFactory(this.hibernateFactory);
        }
        return documentDao;
    }
    public TransactionDaoImpl getTransactionDao() {
        if (taskDao == null) {
            taskDao = new TransactionDaoImpl();
            taskDao.setSessionFactory(this.hibernateFactory);
        }
        return taskDao;
    }
}
