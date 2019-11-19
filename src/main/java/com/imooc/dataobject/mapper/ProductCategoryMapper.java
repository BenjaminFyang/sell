package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-06 11:55
 * @deprecated :
 */
public interface ProductCategoryMapper {

    @Insert("insert into product category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    /**
     * 字段必须对象的实体类保持一致
     *
     * @param productCategory 对象
     * @return int
     */
    @Insert("insert into product category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMap(ProductCategory productCategory);


    /**
     * 查询用户的类目（注意：只能返回这三个字段，其他的字段没有注释，默认为null）
     *
     * @param categoryType categoryId
     * @return ProductCategory
     */
    @Select("select * from product_category where category_type=#{categoryType}")
    @Results({
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType"),
    })
    ProductCategory findByCategoryType(Integer categoryType);

    /**
     * 根据categoryType来更新类目的名字
     *
     * @param categoryName 类目名字
     * @param categoryType 类目类型
     * @return int
     */
    @Update("update product_category set category_name=#{categoryName} where category_type=#{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);

    /**
     * 根据对象来更新操作
     *
     * @param productCategory类目名字
     * @return int
     */
    @Update("update product_category set category_name=#{categoryName} where category_type=#{categoryType}")
    int updateByObject(ProductCategory productCategory);

    /**
     * 根据category_type来删除对象
     *
     * @param category 类目编号
     * @return int
     */
    @Delete("delete from product_category where category_type=#{category_type}")
    int deleteByCategoryType(Integer category);

    ProductCategory selectByCategoryType(Integer categoryType);

}
