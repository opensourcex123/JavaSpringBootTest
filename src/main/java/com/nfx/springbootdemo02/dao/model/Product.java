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
@TableName(value = "product")
public class Product extends BaseModel {
    @TableField(value = "product_name")
    private String productName;

    @TableField(value = "product_image")
    private String productImage;

    @TableField(value = "publisher_name")
    private String publisherName;

    @TableField(value = "product_price")
    private Integer productPrice;

    @TableField(value = "product_stock")
    private Integer productStock;

    @TableField(value = "product_instruction")
    private String productInstruction;

    @TableField(value = "product_type")
    private String productType;

    @TableField(value = "product_discount")
    private Integer productDiscount;

    @TableField(value = "purchase_number")
    private Integer purchaseNumber;

    @TableField(value = "bargaining_allowed")
    private Integer bargainingAllowed;

    @TableField(value = "wear_degree")
    private String wearDegree;

    @TableField(value = "status")
    private Integer status;
}
