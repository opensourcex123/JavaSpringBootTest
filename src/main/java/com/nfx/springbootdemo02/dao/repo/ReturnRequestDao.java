package com.nfx.springbootdemo02.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfx.springbootdemo02.dao.mapper.ReturnRequestMapper;
import com.nfx.springbootdemo02.dao.model.ReturnRequest;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ReturnRequestDao extends ServiceImpl<ReturnRequestMapper, ReturnRequest> {
    @Resource
    private ReturnRequestMapper returnRequestMapper;

    public List<ReturnRequest> getDataByBusinessMan(String businessMan) {
        QueryWrapper<ReturnRequest> wrapper = new QueryWrapper<>();
        wrapper.eq("business_man", businessMan);

        return returnRequestMapper.selectList(wrapper);
    }
}
