package com.nfx.springbootdemo02.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfx.springbootdemo02.dao.mapper.UserMapper;
import com.nfx.springbootdemo02.dao.model.Product;
import com.nfx.springbootdemo02.dao.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDao extends ServiceImpl<UserMapper, User> {
    @Resource
    private UserMapper userMapper;

    public List<User> getAllData(){
        return userMapper.selectList(null);
    }

    public User getOneData(long id) {
        return userMapper.selectById(id);
    }

    public List<User> getCheckingData() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("status", 0);

        return userMapper.selectList(wrapper);
    }

    public int updateStatus(long id, int status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        return userMapper.updateById(user);
    }

    public int updateIncome(long id, int income) {
        User user = new User();
        user.setId(id);
        user.setIncome(income);
        return userMapper.updateById(user);
    }

    public int updateLevel(long id, int level) {
        User user = new User();
        user.setId(id);
        user.setBusinessLevel(level);
        return userMapper.updateById(user);
    }

    public int deleteData(long id) {
        return userMapper.deleteById(id);
    }
}
