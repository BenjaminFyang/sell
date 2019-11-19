package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 方洋
 * @date 2018/1/29 19:22
 */
public interface ProductInfoRepository  extends JpaRepository<ProductInfo,String>{

    /**
     * @param productStatus 商品的状态
     * @return 商品的集合
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
