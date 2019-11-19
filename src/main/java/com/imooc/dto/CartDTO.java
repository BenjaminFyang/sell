package com.imooc.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @author 方洋
 * @date 2018/1/31 14:11
 *      :解释一波构造方法的问题
 *      new一个对象的时候要用到构造函数，例如Hello hello = new Hello();这个时候调用Hello的无参数构造方
 *      法；Hello hello = new Hello("hi");这个是调用Hello有参数构造方法，在java中如果不写构造方法的话，
 *      会默认加上一个无参数的构造方法，但是如果已经有了一个有参数的构造方法，那么无参数的构造方法就不会默
 *      认被加上。如果 Hello类中已经有了一个有参数的构造方法，这时在使用Hello hello = new Hello();来创建
 *      对象的时候就会出错，这就是为什么书上要强调写了有参数的构造方法就最好加一个无参数的构造方法。
 *
 */
@Data
public class CartDTO {
    /**
     * 商品的id.
     */
    private String productId;

    /**
     * 商品的数量.
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
