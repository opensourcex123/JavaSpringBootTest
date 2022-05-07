package com.nfx.springbootdemo02.server.service;

import com.nfx.springbootdemo02.dao.model.ReturnRequest;

import java.util.List;

public interface IReturnRequestService {
    List<ReturnRequest> getReturnRequestByBusiness(ReturnRequest returnRequest);
}
