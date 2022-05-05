package com.nfx.springbootdemo02.server.service;

import com.nfx.springbootdemo02.dao.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllData();
    int updateStatus(Product product);
    List<Product> getCheckingData();
    int createProduct(Product product);
    List<Product> getProductByPublisherName(Product product);
}
