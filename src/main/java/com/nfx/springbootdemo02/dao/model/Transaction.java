package com.nfx.springbootdemo02.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nfx.springbootdemo02.dao.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName(value = "transaction")
public class Transaction extends BaseModel {
    @TableField(value = "payer")
    private Integer payer;

    @TableField(value = "payee")
    private Integer payee;

    @TableField(value = "money")
    private Integer money;

    @TableField(value = "business_level")
    private Integer businessLevel;
}
