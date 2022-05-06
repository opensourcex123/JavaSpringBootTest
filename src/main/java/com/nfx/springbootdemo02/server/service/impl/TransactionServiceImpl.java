package com.nfx.springbootdemo02.server.service.impl;

import com.nfx.springbootdemo02.dao.model.Transaction;
import com.nfx.springbootdemo02.dao.repo.TransactionDao;
import com.nfx.springbootdemo02.server.service.ITransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private TransactionDao transactionDao;

    @Override
    public List<Transaction> getAllData() {
        return transactionDao.getAllData();
    }

    @Override
    public List<Transaction> getDataByPayee(Transaction transaction) {
        return transactionDao.getDataByPayee(transaction.getPayee());
    }

    @Override
    public List<Transaction> getDataByPayer(Transaction transaction) {
        return transactionDao.getDataByPayer(transaction.getPayer());
    }
}
