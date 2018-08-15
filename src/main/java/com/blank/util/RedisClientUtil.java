package com.blank.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *     功能描述:redis缓存工具类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
@Component
public class RedisClientUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 存储数据
     *
     * @param key
     * @param value
     * @param timeOut
     */
    public void put(String key,Object value,long timeOut) {
        redisTemplate.opsForValue().set(key,value,timeOut,TimeUnit.MINUTES);
    }


    /**
     * 移除数据
     *
     * @param key
     */
    public Object delete(String key) {
        redisTemplate.delete(key);
        return get(key);
    }

    /**
     * 得到数据
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取key值集合
     *
     * @param prefix
     * @return
     */
    public Set<String> getKeys(String prefix) {
        return redisTemplate.keys(prefix + "*");
    }


    public void deleteMulti(String prefix) {
        Set<String> keys = getKeys(prefix);
        if(keys != null && !keys.isEmpty()) {
            for(String key : keys) {
                delete(key);
            }
        }
    }

}
