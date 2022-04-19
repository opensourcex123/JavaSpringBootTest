package com.nfx.springbootdemo02.dao.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

@Data
public class BaseModel {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "created_at", jdbcType = JdbcType.DATE)
    private Date createdAt;

    @TableField(value = "updated_at", jdbcType = JdbcType.DATE)
    private Date updatedAt;
}
