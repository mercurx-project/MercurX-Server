package com.mercurx.tradingplatform.dao;

import com.mercurx.tradingplatform.model.Transaction;
import com.mercurx.tradingplatform.model.User;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionDaoImpl {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public int addTransaction(final Transaction task) {
        Session session = null;
        org.hibernate.Transaction transaction = null;
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(task);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status;
    }


    public List<Transaction> getTransactionList() {
        Session session = null;
        org.hibernate.Transaction transaction = null;
        List transactionsList = null;
        try {
            session = this.sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);
            Root<Transaction> rootEntry = cq.from(Transaction.class);
            CriteriaQuery<Transaction> all = cq.select(rootEntry);
            TypedQuery<Transaction> query = session.createQuery(all);
            transactionsList = query.getResultList();
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return transactionsList;
    }


    public Transaction updateTransaction(final Transaction task) {
        Session session = null;
        org.hibernate.Transaction transaction = null;
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(task);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status== 1? task: null;
    }

    public Transaction getLTransaction(final long id){
        Session session = null;
        org.hibernate.Transaction transaction = null;
        Transaction task = new Transaction();
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            Query query = session.createQuery("SELECT u FROM User u WHERE u.id=:id");
            query.setParameter("id", id);
            task =  (Transaction) query.uniqueResult();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return task;
    }
}
