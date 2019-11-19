package com.imooc.constant;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-05 10:42
 * @deprecated : redis常量
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    //2小时
    Integer EXPIRE = 7200;
}
