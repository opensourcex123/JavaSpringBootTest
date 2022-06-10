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

    @PostMapping("/createProduct")
    public ResultData createProduct(@RequestBody Product product) throws Exception {
        int res = productService.createProduct(product);
        if (res != 1) {
            throw new Exception("创建失败！");
        }
        return ResultData.success("创建成功");
    }

    @PostMapping("/getProductByPublisherName")
    public ResultData getProductByPublisherName(@RequestBody Product product) throws Exception {
        List<Product> productList = productService.getProductByPublisherName(product);
        if (productList == null) {
            throw new Exception("未获取到数据");
        }
        return ResultData.success(productList);
    }

    @PostMapping("/deleteProduct")
    public ResultData deleteProduct(@RequestBody Product product) throws Exception {
        int res = productService.deleteProduct(product);
        if (res != 1) {
            throw new Exception("下架失败！");
        }
        return ResultData.success("下架成功");
    }

    @PostMapping("/reduceStorage")
    public ResultData reduceStorage(@RequestBody Product product) throws Exception {
        int res = productService.reduceStorage(product);
        if (res != 1) {
            throw new Exception("库存不足！");
        }
        return ResultData.success("发货成功");
    }

}
