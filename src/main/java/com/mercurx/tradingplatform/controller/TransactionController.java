package com.mercurx.tradingplatform.controller;

import com.mercurx.tradingplatform.model.Transaction;
import com.mercurx.tradingplatform.service.Impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public int createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Transaction getTransactionByID(@PathVariable Long id) {
        return null;
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public Transaction updateTransaction(@RequestBody Transaction transaction) {
        return transactionService.updateTransaction(transaction);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("all")
    public List<Transaction> getTransactionsList() {
       return transactionService.getTransactionsList();
    }
}
