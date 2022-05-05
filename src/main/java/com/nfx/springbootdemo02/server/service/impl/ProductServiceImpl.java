package com.nfx.springbootdemo02.server.service.impl;

import com.nfx.springbootdemo02.dao.model.Product;
import com.nfx.springbootdemo02.dao.repo.ProductDao;
import com.nfx.springbootdemo02.server.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> getAllData() {
        return productDao.getAllData();
    }

    @Override
    public int updateStatus(Product product) {
        return productDao.updateStatus(product.getId(), product.getStatus());
    }

    @Override
    public List<Product> getCheckingData() {
        return productDao.getCheckingData();
    }

    @Override
    public int createProduct(Product product) {
        product.setStatus(0);
        product.setPurchaseNumber(0);
        return productDao.createProduct(product);
    }
}
