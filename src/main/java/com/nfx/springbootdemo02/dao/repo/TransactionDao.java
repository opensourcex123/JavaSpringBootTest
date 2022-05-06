package com.nfx.springbootdemo02.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfx.springbootdemo02.dao.mapper.TransactionMapper;
import com.nfx.springbootdemo02.dao.model.Product;
import com.nfx.springbootdemo02.dao.model.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class TransactionDao extends ServiceImpl<TransactionMapper, Transaction> {
    @Resource
    private TransactionMapper transactionMapper;

    public List<Transaction> getAllData() {
        return transactionMapper.selectList(null);
    }

    public List<Transaction> getDataByPayee(String payee) {
        QueryWrapper<Transaction> wrapper = new QueryWrapper<>();
        wrapper.eq("payee", payee);

        return transactionMapper.selectList(wrapper);
    }
}
