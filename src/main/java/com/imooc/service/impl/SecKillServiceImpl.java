package com.imooc.service.impl;

import com.google.common.collect.Maps;
import com.imooc.exception.SellException;
import com.imooc.service.RedisLock;
import com.imooc.service.SecKillService;
import com.imooc.utils.KeyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-06 17:30
 * @deprecated :
 */
@Service
public class SecKillServiceImpl implements SecKillService {

    /**
     * 表示的是redis中的超时的时间
     */
    private static final int TIMEOUT = 10 * 1000;

    @Resource
    private RedisLock redisLock;

    private static Map<String, Integer> products;
    private static Map<String, Integer> stock;
    private static Map<String, String> orders;

    //模拟多个表，商品信息表，库存表，秒杀成功订单表
    static {
        products = Maps.newHashMap();
        stock = Maps.newHashMap();
        orders = Maps.newHashMap();
        products.put("123456", 10000);
        stock.put("123456", 1000);
    }

    private String queryMap(String productId) {
        return "国庆活动，皮蛋粥特价，限量份"
                + products.get(productId)
                + "还剩：" + stock.get(productId) + "份"
                + "该商品成功下单用户数目："
                + orders.size() + "人";
    }


    @Override
    public String querySecKillProductInfo(String productId) {
        return this.queryMap(productId);
    }

    @Override
    public void orderProductMockDiffUser(String productId) {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId, String.valueOf(time))) {
            throw new SellException(101, "哎呦喂，人也太多了，换个姿势在试试");
        }

        //1.查询改商品库存，为0则活动结束
        Integer stockNum = stock.get(productId);
        if (stockNum == 0) {
            throw new SellException(100, "活动结束");
        } else {
            //2.下单(模拟不同用户openid不同)
            orders.put(KeyUtil.genUniqueKey(), productId);
            //3.减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }
}
