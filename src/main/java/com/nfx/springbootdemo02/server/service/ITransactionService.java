package com.nfx.springbootdemo02.server.service;

import com.nfx.springbootdemo02.dao.model.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> getAllData();
    List<Transaction> getDataByPayee(Transaction transaction);
    List<Transaction> getDataByPayer(Transaction transaction);
    int receiveProduct(Transaction transaction);
}
