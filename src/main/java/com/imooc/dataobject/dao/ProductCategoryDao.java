package com.imooc.dataobject.dao;

import com.imooc.dataobject.mapper.ProductCategoryMapper;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-06 15:01
 * @deprecated :
 */
public class ProductCategoryDao {

    @Resource
    private ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }
}
