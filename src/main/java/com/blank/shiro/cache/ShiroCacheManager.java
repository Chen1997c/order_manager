package com.blank.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *     功能描述:向CacheManager中注入Cache管理类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.10
 */
public class ShiroCacheManager implements CacheManager {

    @Autowired
    private RedisShiroCache redisShiroCache;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisShiroCache;
    }
}
