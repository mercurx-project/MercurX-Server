package com.mercurx.tradingplatform.dao;

import com.mercurx.tradingplatform.model.Benchmark;
import com.mercurx.tradingplatform.model.User;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BenchmarkDaoImpl {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public int addBenchmarkReport(final Benchmark benchmark) {
        Session session = null;
        Transaction transaction = null;
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(benchmark);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status;
    }

    public List<User> getBenchmarkReportList() {
        Session session = null;
        Transaction transaction = null;
        List userList = null;
        try {
            session = this.sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Benchmark> cq = cb.createQuery(Benchmark.class);
            Root<Benchmark> rootEntry = cq.from(Benchmark.class);
            CriteriaQuery<Benchmark> all = cq.select(rootEntry);
            TypedQuery<Benchmark> query = session.createQuery(all);
            userList = query.getResultList();
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userList;
    }


    public int updateBenchmarkReport(final Benchmark benchmark) {
        Session session = null;
        Transaction transaction = null;
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(benchmark);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status;
    }

    public Benchmark getBenchmarkDetails(final long id){
        Session session = null;
        Transaction transaction = null;
        Benchmark benchmark = new Benchmark();
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            Query query = session.createQuery("SELECT u FROM User u WHERE u.id=:id");
            query.setParameter("id", id);
            benchmark =  (Benchmark) query.uniqueResult();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return benchmark;
    }
}
