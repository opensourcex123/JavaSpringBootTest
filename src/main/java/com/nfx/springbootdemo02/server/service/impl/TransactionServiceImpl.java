package com.nfx.springbootdemo02.server.service.impl;

import com.nfx.springbootdemo02.dao.model.Transaction;
import com.nfx.springbootdemo02.dao.repo.TransactionDao;
import com.nfx.springbootdemo02.dao.repo.UserDao;
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
    @Autowired
    private UserDao userDao;

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

    @Override
    public int receiveProduct(Transaction transaction) {
        int payeeMoney;
        int adminMoney = 0;
        int money;
        long id = transaction.getId();
        Transaction transactionTable = transactionDao.getDataById(id);
        money = transactionTable.getMoney();
        // 获取应该给卖家和平台的钱
        switch (transactionTable.getBusinessLevel()) {
            case 1 -> {
                adminMoney = (int) (money * 0.001);
                payeeMoney = money - adminMoney;
            }
            case 2 -> {
                adminMoney = (int) (money * 0.002);
                payeeMoney = money - adminMoney;
            }
            case 3 -> {
                adminMoney = (int) (money * 0.005);
                payeeMoney = money - adminMoney;
            }
            case 4 -> {
                adminMoney = (int) (money * 0.0075);
                payeeMoney = money - adminMoney;
            }
            case 5 -> {
                adminMoney = (int) (money * 0.01);
                payeeMoney = money - adminMoney;
            }
            default -> payeeMoney = money;
        }
        // 给卖家增加收入
        int preIncome = userDao.getDataByName(transactionTable.getPayee()).getIncome();
        userDao.updateIncomeByName(transactionTable.getPayee(), preIncome + payeeMoney);
        // 给平台即admin收入
        preIncome = userDao.getDataByName("admin").getIncome();
        userDao.updateIncomeByName("admin", preIncome + adminMoney);
        // 将交易的是否收货改为是
        transactionDao.updateIsReceive(id, 1);
        return 1;
    }

    @Override
    public int updateTransaction(Transaction transaction) {
        return transactionDao.updateIsDeliver(transaction.getId());
    }
}
