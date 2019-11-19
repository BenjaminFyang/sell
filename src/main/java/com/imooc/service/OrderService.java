package com.imooc.service;

import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author 方洋
 * @date 2018/1/30 19:38
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO 订单对象
     * @return 订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单.
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表.
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单.
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单.
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单.
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * 查询所有的分页的列表
     *
     * @param pageable 分页的对象
     * @return 该页的数据
     */
    Page findList(Pageable pageable);
}
