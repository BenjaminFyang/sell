package com.imooc.enums;

import lombok.Getter;

/**
 * 支付状态的枚举
 *
 * @author 方洋
 * @date 2018/1/30 16:01
 */
@Getter
public enum PayStatusEnum implements CodeEnum{

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
