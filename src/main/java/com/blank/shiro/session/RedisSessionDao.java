package com.blank.shiro.session;

import com.blank.util.RedisClientUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 功能描述:redis缓存shiro会话
 * </p>
 *
 * @author :Team Blank
 * @date :2018.08.10
 */
public class RedisSessionDao extends AbstractSessionDAO {

    @Autowired
    private RedisClientUtil redisClientUtil;

    @Value("${shiro.session.timeout}")
    private Integer timeout;

    private final Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);

    private final String prefix = "shiro_session:";

    private String getKey(String key) {
        return prefix + key;
    }

    private void saveSession(Session session) {
        if (session != null && session.getId() != null) {
            String key = getKey(session.getId().toString());
            Object value = session;
            redisClientUtil.put(key, value,timeout);
        }
    }

    //创建session
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        logger.info("\n\n ============ shiro 创建 session，sessionId=" + sessionId + "=========== \n");
        assignSessionId(session, sessionId);
        saveSession(session);
        return sessionId;
    }

    //读取session
    @Override
    protected Session doReadSession(Serializable serializable) {
        if (serializable != null) {
            String key = getKey(serializable.toString());
            Object value =  redisClientUtil.get(key);
            return (Session) value;
        }
        return null;
    }

    //更新session
    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    //删除session
    @Override
    public void delete(Session session) {
        if (session != null && session.getId() != null) {
            String key = getKey(session.getId().toString());
            redisClientUtil.delete(key);
        }
    }

    //获取全部session
    @Override
    public Collection<Session> getActiveSessions() {
        Set<String> keys = redisClientUtil.getKeys(prefix);
        Set<Session> sessions = new HashSet<>();
        if (CollectionUtils.isEmpty(keys)) {
            return sessions;
        }
        for (String key : keys) {
            sessions.add((Session) redisClientUtil.get(key));
        }
        return null;
    }

}
