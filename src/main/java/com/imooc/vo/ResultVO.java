package com.imooc.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 *
 * @author 方洋
 * @date 2018/1/29 21:07
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -8349181922768084604L;
    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体内容.
     */
    private T data;
}
