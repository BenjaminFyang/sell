package com.imooc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情
 * @author 方洋
 * @date 2018/1/30 10:54
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("description")
    private BigDecimal productDescription;

    @JsonProperty("icon")
    private String productIcon;


}
