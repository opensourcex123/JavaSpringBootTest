package com.nfx.springbootdemo02.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfx.springbootdemo02.dao.mapper.ProductMapper;
import com.nfx.springbootdemo02.dao.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProductDao extends ServiceImpl<ProductMapper, Product> {
    @Resource
    private ProductMapper productMapper;

    public List<Product> getAllData() {
        return productMapper.selectList(null);
    }

    public int updateStatus(Long id, int status) {
        Product product = new Product();
        product.setId(id);
        product.setStatus(status);
        return productMapper.updateById(product);
    }

    public List<Product> getCheckingData() {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("status", 0);

        return productMapper.selectList(wrapper);
    }

    public int createProduct(Product product) {
        return productMapper.insert(product);
    }

    public List<Product> getProductByPublisherName(String publisherName) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("publisher_name", publisherName);

        return productMapper.selectList(wrapper);
    }
}
