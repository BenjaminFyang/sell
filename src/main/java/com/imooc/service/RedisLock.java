package com.imooc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-06 16:31
 * @deprecated :  /**
 * * @deprecated : setnx(redis中的命令)：将key设置值为value,如果key不存在，在这种情况下
 * 等同SET命令。当key存在时，什么也不做。SETNX是"SET if Not exists"的简写。
 * 返回值
 * Integer reply,特定值：
 * .1 如果key被设置了
 * .0 如果key没有被设置(返回0表示该键已经被其他客户端锁定)
 * <p>
 * <p>
 * getset自动将key对应到value并且返回原来key对应的value。如果key存在但是对应的value
 * 不是字符串，就返回错误
 * <p>
 * getset可以和incr一起使用实现支持重置的计数功能。举个例子：每当有事件发生的时候，一段程序
 * 都会调用incr给key mycounter加一，但是有时我们需要获取计数器的值，并且自动将其重置为0.这个
 * 可以通过getset mycounter "0"来实现
 */

@Component
@Slf4j
public class RedisLock {
    @Resource
    private StringRedisTemplate redisTemplate;

    /**
     * redis的分布式的锁机制(加锁)
     *
     * @param key   redis中的键
     * @param value redis中的值（当前时间+超时时间）
     * @return boolean
     */
    public boolean lock(String key, String value) {
        //判断这个值是否已经被锁定，如果被锁定就返回true这个值
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        //currentValue=A    这两个线程的value都是B 其中一个线程拿到锁
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁的步骤
     *
     * @param key   redis中的键
     * @param value redis中的值（当前时间+超时时间）
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("【redis分布式锁】解锁异常，{}", e);
        }
    }
}
