package com.imooc.utils;

import java.util.Random;

/**
 * @author 方洋
 * @date 2018/1/31 11:59
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间 + 随机数  加上synchronized修饰的关键字，可以防止并发产生重复的主键id
     *
     * @return 随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        //生成六位随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
