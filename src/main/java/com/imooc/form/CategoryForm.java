package com.imooc.form;

import lombok.Data;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-02 11:45
 * @deprecated : 类目提交过来的表单的信息
 */
@Data
public class CategoryForm {
    /**
     * Id.
     */
    private Integer categoryId;

    /**
     * 类目名字.
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;
}
