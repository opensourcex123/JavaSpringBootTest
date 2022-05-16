package com.nfx.springbootdemo02.dao.repo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfx.springbootdemo02.dao.mapper.CommentMapper;
import com.nfx.springbootdemo02.dao.model.Comment;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class CommentDao extends ServiceImpl<CommentMapper, Comment> {
    @Resource
    private CommentMapper commentMapper;


}
