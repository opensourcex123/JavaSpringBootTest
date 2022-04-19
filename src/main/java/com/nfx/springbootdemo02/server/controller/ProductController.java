package com.nfx.springbootdemo02.server.controller;

import com.nfx.springbootdemo02.dao.model.Product;
import com.nfx.springbootdemo02.dao.model.User;
import com.nfx.springbootdemo02.server.domain.http.ResultData;
import com.nfx.springbootdemo02.server.service.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/get")
    public ResultData getAllData() throws Exception {
        List<Product> productList = productService.getAllData();
        if (productList == null) {
            throw new Exception("未获取到数据");
        }
        if (productList.isEmpty()) {
            return ResultData.success("无数据");
        }
        return ResultData.success(productList);
    }

    @PostMapping("/updateStatus")
    public ResultData updateStatus(@RequestBody Product product) throws Exception {
        int res = productService.updateStatus(product);
        if (res != 1) {
            throw new Exception("更新失败！");
        }
        return ResultData.success("更新成功");
    }

    @PostMapping("/getCheckingData")
    public ResultData getCheckingData() throws Exception {
        List<Product> productList = productService.getCheckingData();
        if (productList == null) {
            throw new Exception("未获取到数据");
        }
        return ResultData.success(productList);
    }
}
