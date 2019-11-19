package com.imooc.enums;

import lombok.Getter;

/**
 * @author 方洋
 * @date 2018/1/30 15:51
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    /**
     * 订单的状态
     */
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
