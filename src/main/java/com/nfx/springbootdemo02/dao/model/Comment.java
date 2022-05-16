package com.nfx.springbootdemo02.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.nfx.springbootdemo02.dao.base.BaseModel;

public class Comment extends BaseModel {
    @TableField(value = "user_id")
    private long userId;

    @TableField(value = "product_id")
    private long productId;

    @TableField(value = "comment")
    private String comment;

    @TableField(value = "type")
    private Integer type;
}
