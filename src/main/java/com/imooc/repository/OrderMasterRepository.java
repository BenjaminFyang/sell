package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 方洋
 * @date 2018/1/30 16:55
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 根据 buyerOpenid查询到用户的订单
     *
     * @param buyerOpenid 微信的Openid
     * @param pageable    分页的对象
     * @return 分页后的订单
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
