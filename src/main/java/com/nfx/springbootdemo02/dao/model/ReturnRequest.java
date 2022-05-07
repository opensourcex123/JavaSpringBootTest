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
@TableName(value = "return_request")
public class ReturnRequest extends BaseModel {
    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "business_man")
    private String businessMan;

    @TableField(value = "product_name")
    private String productName;

    @TableField(value = "money")
    private Integer money;

    @TableField(value = "request_message")
    private String requestMessage;

    @TableField(value = "reject_message")
    private String rejectMessage;

    @TableField(value = "status")
    private Integer status;
}
