package com.imooc.utils;

/**
 * @author 方洋
 * @date 2018/2/8 16:13
 */
public class MathUtil {

    /**
     * 两个金额相比较相等的最小的误差
     */
    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较两个金额是否相等
     *
     * @param d1 商品金额
     * @param d2 微信回调金额
     * @return Boolean
     */
    public static Boolean equals(Double d1, Double d2) {
        //表示的是两个数相差的绝对值
        Double result = Math.abs(d1 - d2);
        return result < MONEY_RANGE;
    }
}
