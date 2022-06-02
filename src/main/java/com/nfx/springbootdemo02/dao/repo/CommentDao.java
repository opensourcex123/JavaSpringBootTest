package com.nfx.springbootdemo02.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfx.springbootdemo02.dao.mapper.CommentMapper;
import com.nfx.springbootdemo02.dao.model.Comment;
import com.nfx.springbootdemo02.dao.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CommentDao extends ServiceImpl<CommentMapper, Comment> {
    @Resource
    private CommentMapper commentMapper;

    public List<Comment> getCommentByProductAndType(long productId, int type) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id", productId);
        wrapper.eq("type", type);

        return commentMapper.selectList(wrapper);
    }

    public List<Comment> getAllComment() {
        return commentMapper.selectList(null);
    }
}
