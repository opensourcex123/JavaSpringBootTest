package com.nfx.springbootdemo02.server.service;

import com.nfx.springbootdemo02.dao.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllData();
}
