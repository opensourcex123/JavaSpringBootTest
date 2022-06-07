package com.nfx.springbootdemo02.server.controller;

import com.nfx.springbootdemo02.dao.model.ReturnRequest;
import com.nfx.springbootdemo02.dao.model.Transaction;
import com.nfx.springbootdemo02.server.domain.http.ResultData;
import com.nfx.springbootdemo02.server.service.impl.ReturnRequestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/return_request")
public class ReturnRequestController {
    @Autowired
    private ReturnRequestServiceImpl returnRequestService;

    @PostMapping("/getReturnRequestByBusinessMan")
    public ResultData getReturnRequestByBusiness(@RequestBody ReturnRequest returnRequest) throws Exception {
        List<ReturnRequest> returnRequests = returnRequestService.getReturnRequestByBusiness(returnRequest);
        if (returnRequests.isEmpty()) {
            return ResultData.success("无数据");
        }
        return ResultData.success(returnRequests);
    }

    @PostMapping("/getReturnRequestByUserName")
    public ResultData getReturnRequestByUserName(@RequestBody ReturnRequest returnRequest) throws Exception {
        List<ReturnRequest> returnRequests = returnRequestService.getReturnRequestByUserName(returnRequest);
        if (returnRequests.isEmpty()) {
            return ResultData.success("无数据");
        }
        return ResultData.success(returnRequests);
    }

    @PostMapping("/updateReturnRequest")
    public ResultData updateReturnRequest(@RequestBody ReturnRequest returnRequest) throws Exception {
        int res = returnRequestService.updateReturnRequestById(returnRequest);

        if (res != 1) {
            throw new Exception("更新失败！");
        }

        return ResultData.success("更新成功");
    }
}
