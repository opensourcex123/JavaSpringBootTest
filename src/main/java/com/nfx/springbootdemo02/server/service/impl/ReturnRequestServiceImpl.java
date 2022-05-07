package com.nfx.springbootdemo02.server.service.impl;

import com.nfx.springbootdemo02.dao.model.ReturnRequest;
import com.nfx.springbootdemo02.dao.repo.ReturnRequestDao;
import com.nfx.springbootdemo02.server.service.IReturnRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnRequestServiceImpl implements IReturnRequestService {
    @Autowired
    private ReturnRequestDao returnRequestDao;

    @Override
    public List<ReturnRequest> getReturnRequestByBusiness(ReturnRequest returnRequest) {
        return returnRequestDao.getDataByBusinessMan(returnRequest.getBusinessMan());
    }
}
