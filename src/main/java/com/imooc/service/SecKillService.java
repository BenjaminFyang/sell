package com.imooc.service;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-06 17:30
 * @deprecated :
 */
public interface SecKillService {
    /**
     * 查询秒杀库存数
     *
     * @param productId 商品的productId
     * @return String
     */
    String querySecKillProductInfo(String productId);

    /**
     * 秒杀商品接口
     *
     * @param productId 商品的productId
     */
    void orderProductMockDiffUser(String productId);


}
