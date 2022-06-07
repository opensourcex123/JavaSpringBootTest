package com.nfx.springbootdemo02.server.service.impl;

import com.nfx.springbootdemo02.dao.model.ReturnRequest;
import com.nfx.springbootdemo02.dao.model.User;
import com.nfx.springbootdemo02.dao.repo.ReturnRequestDao;
import com.nfx.springbootdemo02.dao.repo.UserDao;
import com.nfx.springbootdemo02.server.service.IReturnRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnRequestServiceImpl implements IReturnRequestService {
    @Autowired
    private ReturnRequestDao returnRequestDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<ReturnRequest> getReturnRequestByBusiness(ReturnRequest returnRequest) {
        return returnRequestDao.getDataByBusinessMan(returnRequest.getBusinessMan());
    }

    @Override
    public List<ReturnRequest> getReturnRequestByUserName(ReturnRequest returnRequest) {
        return returnRequestDao.getDataByUserName(returnRequest.getUserName());
    }

    @Override
    public int updateReturnRequestById(ReturnRequest returnRequest) {
        ReturnRequest returnRequestTable = returnRequestDao.getById(returnRequest.getId());
        if (returnRequest.getStatus() == 1) {
            String userName = returnRequestTable.getUserName();
            String businessMan = returnRequestTable.getBusinessMan();
            User user = userDao.getDataByName(userName);
            User business = userDao.getDataByName(businessMan);
            User admin = userDao.getDataByName("admin");
            // 计算管理员和卖家应退的钱
            int money = returnRequestTable.getMoney();
            int adminMoney = 0;
            int payeeMoney;
            switch (business.getBusinessLevel()) {
                case 1 -> {
                    adminMoney = (int) (money * 0.001);
                    payeeMoney = money - adminMoney;
                }
                case 2 -> {
                    adminMoney = (int) (money * 0.002);
                    payeeMoney = money - adminMoney;
                }
                case 3 -> {
                    adminMoney = (int) (money * 0.005);
                    payeeMoney = money - adminMoney;
                }
                case 4 -> {
                    adminMoney = (int) (money * 0.0075);
                    payeeMoney = money - adminMoney;
                }
                case 5 -> {
                    adminMoney = (int) (money * 0.01);
                    payeeMoney = money - adminMoney;
                }
                default -> payeeMoney = money;
            }
            // 给用户退钱
            int preIncome = user.getIncome();
            userDao.updateIncomeByName(userName, preIncome + returnRequestTable.getMoney());
            // 把卖家的钱收回来
            preIncome = business.getIncome();
            userDao.updateIncomeByName(businessMan, preIncome - payeeMoney);
            // 把admin的钱收回来
            preIncome = admin.getIncome();
            userDao.updateIncomeByName("admin", preIncome - adminMoney);
            return returnRequestDao.updateDataById(returnRequest.getId(), returnRequest.getStatus(), returnRequest.getRejectMessage());
        } else {
            return returnRequestDao.updateDataById(returnRequest.getId(), returnRequest.getStatus(), returnRequest.getRejectMessage());
        }
    }
}
