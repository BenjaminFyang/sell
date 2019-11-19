package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-02 14:29
 * @deprecated : 表示的是用户表的Dao
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    /**
     * 查询用户表
     *
     * @param openid 微信上的唯一标识
     * @return SellerInfo
     */
    SellerInfo findByOpenid(String openid);

}
