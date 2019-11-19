package com.imooc.dataobject.mapper;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;


/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-06 12:00
 * @deprecated :
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {
    @Resource
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("categoryName", "师兄最不爱");
        map.put("categoryType", "101");
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

}