package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @author 方洋
 * @date 2018/1/29 17:56
 */
public interface CategoryService {

    /** 表示的卖家端 */
    ProductCategory findOne(Integer categoryId);

    /**表示的是买家端 */
    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory );
}
