package com.nfx.springbootdemo02.server.service.impl;

import com.nfx.springbootdemo02.dao.model.Admin;
import com.nfx.springbootdemo02.dao.model.User;
import com.nfx.springbootdemo02.dao.repo.UserDao;
import com.nfx.springbootdemo02.server.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user.getName(), user.getPassword());
    }

    @Override
    public List<User> getAllData() {
        return userDao.getAllData();
    }

    @Override
    public User getDataByName(User user) {
        return userDao.getDataByName(user.getName());
    }

    @Override
    public User getOneData(long id) {
        return userDao.getOneData(id);
    }

    @Override
    public List<User> getCheckingData() {
        return userDao.getCheckingData();
    }

    @Override
    public int updateStatus(User user) {
        return userDao.updateStatus(user.getId(), user.getStatus());
    }

    @Override
    public int updateIncome(User user) {
        return userDao.updateIncome(user.getId(), user.getIncome());
    }

    @Override
    public int updateLevel(User user) {
        return userDao.updateLevel(user.getId(), user.getBusinessLevel());
    }

    @Override
    public int deleteData(Long id) {
        return userDao.deleteData(id);
    }
}
