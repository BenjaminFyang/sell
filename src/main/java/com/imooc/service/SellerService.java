package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-02 15:10
 * @deprecated : 卖家端
 */
public interface SellerService {

    /**
     * 根据openid来查询用户的信息
     *
     * @param openid 微信端标识用户的
     * @return SellerInfo
     */
    SellerInfo findSellerInfoByOpenid(String openid);

}
