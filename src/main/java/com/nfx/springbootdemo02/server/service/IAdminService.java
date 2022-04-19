package com.nfx.springbootdemo02.server.service;

import com.nfx.springbootdemo02.dao.model.Admin;

import java.util.List;

public interface IAdminService {
    List<Admin> getAdmin();
    Admin login(Admin admin);
}
