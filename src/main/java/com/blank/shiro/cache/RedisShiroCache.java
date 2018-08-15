package com.blank.shiro.cache;

import com.blank.util.RedisClientUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *     功能描述:实现redis缓存shiro授权信息
 * </p>
 *
 * @param <K>
 * @param <V>
 *
 * @author :Team Blank
 * @since :2018.08.10
 */
@Component
public class RedisShiroCache<K, V> implements Cache<K, V> {

    @Autowired
    private RedisClientUtil redisClientUtil;

    @Value("${shiro.cache.timeout}")
    private Integer timeout;

    private final String prefix = "shiro_cache:";

    //concurrentHashMap作为本地缓存
    private final ConcurrentHashMap<Object,Object> concurrentHashMap = new ConcurrentHashMap<>(5);

    public String getKey(K key) {
        return prefix + key.toString();
    }

    @Override
    public V get(K k) throws CacheException {
        Object value = concurrentHashMap.get(getKey(k));//从concurrentHashMap中取
        if(value != null) {
            return (V) value;
        }
        value = redisClientUtil.get(getKey(k));
        if(value != null) {
            concurrentHashMap.put(getKey(k),value);//存放到concurrentHashMap中
            return (V) value;
        }
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        String key = getKey(k);
        Object value = v;
        redisClientUtil.put(key,value,timeout);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        String key = getKey(k);
        Object value = redisClientUtil.get(key);
        concurrentHashMap.remove(getKey(k));
        redisClientUtil.delete(key);
        if(value != null)
            return (V) value;
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
