package com.imooc.controller;

import com.imooc.service.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-06 18:13
 */
@RestController
@Slf4j
public class SeckillController {
    @Resource
    private SecKillService secKillService;

    /**
     * 查询秒杀活动特价商品的信息
     *
     * @param productId 商品的id
     * @return String
     * @throws Exception 异常抛出
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId) throws Exception {
        return secKillService.querySecKillProductInfo(productId);
    }

    /**
     * 秒杀，没有抢到获得"哎呦喂，xxxxxx",抢到了会返回剩余的库存量
     *
     * @param productId 商品的id
     * @return String
     * @throws Exception 异常抛出
     */
    @GetMapping("order/{productId}")
    public String skill(@PathVariable String productId) throws Exception {
        log.info("@skill request ,productId:" + productId);
        secKillService.orderProductMockDiffUser(productId);
        return secKillService.querySecKillProductInfo(productId);
    }

}
