package com.mercurx.tradingplatform.dao;

import com.mercurx.tradingplatform.model.Metrics;
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

public class MetricsDaoImpl {

    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public int saveMetricsData(final Metrics lcase) {
        Session session = null;
        Transaction transaction = null;
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(lcase);
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

    public List<User> getAllMetrics() {
        Session session = null;
        Transaction transaction = null;
        List caseList = null;
        try {
            session = this.sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Metrics> cq = cb.createQuery(Metrics.class);
            Root<Metrics> rootEntry = cq.from(Metrics.class);
            CriteriaQuery<Metrics> all = cq.select(rootEntry);
            TypedQuery<Metrics> query = session.createQuery(all);
            caseList = query.getResultList();
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return caseList;
    }


    public int updateMetrics(final Metrics metrics) {
        Session session = null;
        Transaction transaction = null;
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(metrics);
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

    public Metrics getMetricsByID(final long id){
        Session session = null;
        Transaction transaction = null;
        Metrics user = new Metrics();
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            Query query = session.createQuery("SELECT u FROM User u WHERE u.id=:id");
            query.setParameter("id", id);
            user =  (Metrics) query.uniqueResult();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }
}
