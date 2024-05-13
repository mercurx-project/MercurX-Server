package com.mercurx.tradingplatform.service;

import com.mercurx.tradingplatform.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction getTaskById(long id);
    int createTransaction(Transaction transaction);
    Transaction updateTransaction(Transaction transaction);
    void deleteTransaction(Long id);
    List<Transaction> getTransactionsList();
}
