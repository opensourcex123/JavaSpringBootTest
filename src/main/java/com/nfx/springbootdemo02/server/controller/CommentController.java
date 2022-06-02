package com.nfx.springbootdemo02.server.controller;

import com.nfx.springbootdemo02.dao.model.Comment;
import com.nfx.springbootdemo02.dao.model.Product;
import com.nfx.springbootdemo02.server.domain.http.ResultData;
import com.nfx.springbootdemo02.server.service.impl.CommentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping("/get")
    public ResultData getAllData() throws Exception {
        List<Comment> commentList = commentService.getAllData();
        if (commentList == null) {
            throw new Exception("未获取到数据");
        }
        if (commentList.isEmpty()) {
            return ResultData.success("无数据");
        }
        return ResultData.success(commentList);
    }
}
