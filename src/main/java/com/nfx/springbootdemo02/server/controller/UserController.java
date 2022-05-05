package com.nfx.springbootdemo02.server.controller;

import com.nfx.springbootdemo02.dao.model.Admin;
import com.nfx.springbootdemo02.dao.model.Product;
import com.nfx.springbootdemo02.dao.model.User;
import com.nfx.springbootdemo02.server.domain.http.ResultData;
import com.nfx.springbootdemo02.server.service.IUserService;
import com.nfx.springbootdemo02.server.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public ResultData login(@RequestBody User user) throws Exception {
        User userTable = userService.login(user);
        if (userTable == null) {
            return ResultData.failure("用户不存在");
        }
        if (!userTable.getPassword().equals(user.getPassword())) {
            throw new Exception("用户名或密码错误！");
        }
        if (userTable.getStatus() != 1) {
            return ResultData.failure("用户还未通过审核");
        }
        return ResultData.success(userTable.getName());
    }

    @PostMapping("/logout")
    public ResultData logout() {
        return ResultData.success("退出登陆");
    }

    @PostMapping("/getDataByName")
    public ResultData getDataByName(@RequestBody User user) throws Exception {
        User userTable = userService.getDataByName(user);
        if (userTable == null) {
            throw new Exception("未获取到数据");
        }
        return ResultData.success(userTable);
    }

    @PostMapping("/get")
    public ResultData getAllData() throws Exception {
        List<User> userList = userService.getAllData();
        if (userList == null) {
            throw new Exception("未获取到数据");
        }
        if (userList.isEmpty()) {
            return ResultData.success("无数据");
        }
        return ResultData.success(userList);
    }

    @PostMapping("/getCheckingData")
    public ResultData getCheckingData() throws Exception {
        List<User> userList = userService.getCheckingData();
        if (userList == null) {
            throw new Exception("未获取到数据");
        }
        return ResultData.success(userList);
    }

    @PostMapping("/updateStatus")
    public ResultData updateStatus(@RequestBody User user) throws Exception {
        int res = userService.updateStatus(user);
        if (res != 1) {
            throw new Exception("更新失败！");
        }
        return ResultData.success("更新成功");
    }

    @PostMapping("/updateIncome")
    public ResultData updateIncome(@RequestBody User user) throws Exception {
        int res = userService.updateIncome(user);
        if (res != 1) {
            throw new Exception("充值失败！");
        }
        return ResultData.success("充值成功");
    }

    @PostMapping("/updateLevel")
    public ResultData updateLevel(@RequestBody User user) throws Exception {
        int res = userService.updateLevel(user);
        if (res != 1) {
            throw new Exception("更新失败！");
        }
        return ResultData.success("更新成功");
    }

    @PostMapping("/delete")
    public ResultData deleteData(@RequestBody User user) throws Exception {
        int res = userService.deleteData(user.getId());
        if (res != 1) {
            throw new Exception("删除失败！");
        }
        return ResultData.success("删除成功");
    }
}
