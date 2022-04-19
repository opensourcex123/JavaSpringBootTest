package com.nfx.springbootdemo02.server.controller;

import com.nfx.springbootdemo02.dao.model.Transaction;
import com.nfx.springbootdemo02.dao.model.User;
import com.nfx.springbootdemo02.server.domain.http.ResultData;
import com.nfx.springbootdemo02.server.service.impl.TransactionServiceImpl;
import com.nfx.springbootdemo02.server.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping("/get")
    public ResultData getAllData() throws Exception {
        List<Transaction> transactions = transactionService.getAllData();
        if (transactions.isEmpty()) {
            return ResultData.success("无数据");
        }
        return ResultData.success(transactions);
    }
}
