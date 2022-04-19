package com.nfx.springbootdemo02.server.service;

import com.nfx.springbootdemo02.dao.model.Product;
import com.nfx.springbootdemo02.dao.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllData();
    User getOneData(long id);
    List<User> getCheckingData();
    int updateStatus(User user);
    int updateIncome(User user);
    int updateLevel(User user);
    int deleteData(Long id);
}
