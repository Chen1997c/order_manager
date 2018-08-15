package com.blank.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * <p>
 * 功能描述:通过WebSocket推送消息
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
@ServerEndpoint("/noticeServer")
@Component
public class NoticeWebSocket {

    private final Logger logger = LoggerFactory.getLogger(NoticeWebSocket.class);

    //记录当前在线数
    private static int onlineCount = 0;

    //CopyOnWriteArraySet是线程安全的，存放每个客户端的webSocket对象
    private static CopyOnWriteArraySet<NoticeWebSocket> webSocketSet
            = new CopyOnWriteArraySet<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 建立连接时调用的方法
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        logger.info("\n\n ================== NoticeWebSocket 有新连接加入！当前在线人数为" + getOnlineCount() + "========== \n");
    }

    /**
     * 关闭连接时调用的方法
     *
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();;
        logger.info("\n\n ================== NoticeWebSocket 有一连接关闭！当前在线人数为" + getOnlineCount() + " ========== \n");
    }


    /**
     * 发送消息的方法
     *
     * @param message
     * @throws IOException
     */
    public  void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 出错时调用的方法
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session,Throwable throwable) {
        logger.info("\n\n ================== NoticeWebSocket 发生错误 ============= \n");
        logger.info(" 错误信息为 ----> " + throwable);
    }

    /**
     * synchronized关键字保证了该段代码在并发情况下不会被同时执行
     *
     * @return
     */
    public static synchronized int getOnlineCount(){
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        NoticeWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        NoticeWebSocket.onlineCount--;
    }
}
