package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * 支付
 *
 * @author 方洋
 * @date 2018/2/7 16:04
 */
public interface PayService {

    /**
     * 创建订单
     *
     * @param orderDTO 前端传的订单对象
     * @return 微信支付是否成功
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 进行微信支付结果之后的异步的通知
     *
     * @param notifyData
     * @return PayResponse
     */
    PayResponse notify(String notifyData);

    /**
     * 微信退款通知
     *
     * @param orderDTO 前端传的订单对象
     */
    RefundResponse refund(OrderDTO orderDTO);

}
