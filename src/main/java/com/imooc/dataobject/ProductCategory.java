package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * 类目
 * Created by fy
 * 2017-05-07 14:30
 * @deprecated ：@Entity表示的是将数据库映射成对象
 *             ：@Id 表示数据库中映射的主键
 *             ：@GeneratedValue 表示主键是自增类型的
 *             ：@DynamicUpdate 表示的是动态的更新
 * @author mayn
 */
@Entity
@DynamicUpdate
@Data
@Table(name = "product_category")
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 修改时间. */
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}
