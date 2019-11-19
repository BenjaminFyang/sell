package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 方洋
 * @date 2018/1/30 17:14
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 查询到用户的订单商品集合
     *
     * @param buyerOpenid 微信的openid
     * @param pageable    分页的对象
     * @return 该用户的订单商品的集合
     */
    List<OrderDetail> findByOrderId(String buyerOpenid);
}
