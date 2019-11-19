package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 *
 * @author 方洋
 * @date 2018/1/29 19:41
 */
public interface ProductService {

    /**
     * 根据商品的id寻找商品信息
     *
     * @param productId 商品的id
     * @return 商品
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有在在架商品列表
     *
     * @return 商品的对象
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页
     *
     * @param pageable 分页的对象
     * @return 分页之后的对象的集合
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     *
     * @param cartDTOList 商品的id，数量集合的对象
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     *
     * @param cartDTOList 商品的id，数量集合的对象
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架
     *
     * @param productId 商品的id
     * @return ProductInfo
     */
    ProductInfo onSale(String productId);

    /**
     * 下架
     *
     * @param productId 商品的id
     * @return ProductInfo
     */
    ProductInfo offSale(String productId);
}
