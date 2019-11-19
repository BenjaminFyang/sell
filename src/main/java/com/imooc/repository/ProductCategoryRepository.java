package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fy
 * 2017-05-07 14:35
 * @author mayn
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * dsad
     * @param categoryTypeList shuju
     * @return de
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
