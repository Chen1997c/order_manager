package com.blank.mapper.cache;

import com.blank.util.RedisClientUtil;
import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 *     功能描述:实现mybatis缓存sql查询结果
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.11
 */
public class MybatisRedisCache implements Cache {

    private final String id;

    private final String prefix = "mybatis_cache:";

    private String getKey(String key) {
        return prefix + key;
    }

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    //保存时长为30分
    private final Integer timeOut = 30;

    private RedisClientUtil redisClientUtil;

    //手动注入RedisClientUtil
    private RedisClientUtil getRedisClientUtil() {
        if(redisClientUtil == null)
            redisClientUtil = (RedisClientUtil) ApplicationContextHolder.getClass(RedisClientUtil.class);
        return redisClientUtil;
    }

    @Override
    public String getId() {
        return this.id;
    }

    /**
     * 存放
     *
     * @param o
     * @param o1
     */
    @Override
    public void putObject(Object o, Object o1) {
        RedisClientUtil redisClientUtil = getRedisClientUtil();
        redisClientUtil.put(getKey(o.toString()),o1,timeOut);
    }

    /**
     * 获取
     *
     * @param o
     * @return
     */
    @Override
    public Object getObject(Object o) {
        RedisClientUtil redisClientUtil = getRedisClientUtil();
        Object value = redisClientUtil.get(getKey(o.toString()));
        return value;
    }

    /**
     * 删除
     *
     * @param o
     * @return
     */
    @Override
    public Object removeObject(Object o) {
        RedisClientUtil redisClientUtil = getRedisClientUtil();
        return redisClientUtil.delete(getKey(o.toString()));
    }

    /**
     * 清空mybatis相关缓存
     */
    @Override
    public void clear() {
        RedisClientUtil redisClientUtil = getRedisClientUtil();
        redisClientUtil.deleteMulti(prefix);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
