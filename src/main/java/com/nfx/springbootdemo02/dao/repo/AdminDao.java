package com.nfx.springbootdemo02.dao.repo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfx.springbootdemo02.dao.mapper.AdminMapper;
import com.nfx.springbootdemo02.dao.model.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Repository
public class AdminDao extends ServiceImpl<AdminMapper, Admin> {
    @Resource
    private AdminMapper adminMapper;

    public Admin login(String userName, String password) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<Admin>();
        wrapper.eq("user_name", userName);

        return adminMapper.selectOne(wrapper);
    }
}
