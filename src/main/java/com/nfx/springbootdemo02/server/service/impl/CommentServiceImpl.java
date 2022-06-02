package com.nfx.springbootdemo02.server.service.impl;

import com.nfx.springbootdemo02.dao.model.Comment;
import com.nfx.springbootdemo02.dao.repo.CommentDao;
import com.nfx.springbootdemo02.server.service.ICommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements ICommentService {
    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> getAllData() {
        return commentDao.getAllComment();
    }
}
