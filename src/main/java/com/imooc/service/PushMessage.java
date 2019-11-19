package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-05 16:59
 * @deprecated :
 */
public interface PushMessage {

    /**
     * 订单状态变更消息
     *
     * @param orderDTO 封装的对象
     */
    void orderStatus(OrderDTO orderDTO);
}
