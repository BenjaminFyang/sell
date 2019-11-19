package com.imooc.enums;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author 方洋
 * @date 2018/1/29 20:09
 * :构造方法的快捷键 alt+insert
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {

    //商品状态的展示
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
