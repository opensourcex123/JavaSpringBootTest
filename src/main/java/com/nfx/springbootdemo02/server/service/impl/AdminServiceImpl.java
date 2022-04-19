package com.nfx.springbootdemo02.server.service.impl;

import com.nfx.springbootdemo02.dao.model.Admin;
import com.nfx.springbootdemo02.dao.repo.AdminDao;
import com.nfx.springbootdemo02.server.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> getAdmin() {
        return adminDao.list();
    }

    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin.getUserName(), admin.getPassword());
    }
}
