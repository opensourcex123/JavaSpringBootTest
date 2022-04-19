package com.nfx.springbootdemo02.server.controller;

import com.nfx.springbootdemo02.dao.model.Admin;
import com.nfx.springbootdemo02.server.domain.http.ResultData;
import com.nfx.springbootdemo02.server.service.impl.AdminServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/login")
    public ResultData login(@RequestBody Admin admin) throws Exception {
        Admin adminTable = adminService.login(admin);
        if (!adminTable.getPassword().equals(admin.getPassword())) {
            throw new Exception("用户名或密码错误！");
        }

        return ResultData.success(adminTable);
    }

    @PostMapping("/logout")
    public ResultData logout() {
        return ResultData.success("退出登陆");
    }

    @PostMapping("/get")
    public ResultData getAdmin() throws Exception {
        List<Admin> adminList = this.adminService.getAdmin();
        if (adminList == null) {
            throw new Exception("错误！");
        }
        return ResultData.success(adminList);
    }
}