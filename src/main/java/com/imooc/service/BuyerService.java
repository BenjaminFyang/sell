package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 买家
 *
 * @author 方洋
 * @date 2018/2/2 19:58
 */
public interface BuyerService {

    /**
     * 查询一个订单
     *
     * @param openid  微信的openid
     * @param orderId 该用户商品的订单号
     * @return 该订单
     */
    OrderDTO findOrderOne(String openid, String orderId);


    /**
     * 取消订单
     *
     * @param openid  微信的openid
     * @param orderId 该用户商品的订单号
     * @return 该订单
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
