package com.mercurx.tradingplatform.service.Impl;

import com.mercurx.tradingplatform.dao.HibernateDaoFactory;
import com.mercurx.tradingplatform.model.Transaction;
import com.mercurx.tradingplatform.model.User;
import com.mercurx.tradingplatform.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private HibernateDaoFactory hibernateDaoFactory;
    @Override
    public Transaction getTaskById(long id) {
        return this.hibernateDaoFactory.getTransactionDao().getLTransaction(id);
    }

    @Override
    public int createTransaction(Transaction transaction) {
        return this.hibernateDaoFactory.getTransactionDao().addTransaction(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return this.hibernateDaoFactory.getTransactionDao().updateTransaction(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {

    }

    @Override
    public List<Transaction> getTransactionsList() {
        return this.hibernateDaoFactory.getTransactionDao().getTransactionList();
    }
}
