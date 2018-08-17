package com.blank.controller.admin;

import com.blank.controller.BaseController;
import com.blank.shiro.cache.RedisShiroCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * <p>
 * 功能描述:管理员前端控制器(首页)
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.12
 */
@Controller
@RequestMapping("/admin")
public class AdminIController extends BaseController {

    //创建线程安全的set存储通知
    private final ConcurrentSkipListSet<String> noticeSet = new ConcurrentSkipListSet<>();


    //通知cookie保存时长
    @Value("${notice.cookie.maxAge}")
    private Integer maxAge;

    @Autowired
    private RedisShiroCache redisShiroCache;

    /**
     * 返回登录视图
     *
     * @param model
     * @return
     */
    @RequestMapping("/index.html")
    public String index(Model model, HttpSession session) {
        return "admin/index";
    }

    /**
     * 发送通知
     *
     * @param message
     */
    @PostMapping("/postNotice")
    @ResponseBody
    public void postNotice(String message, String account) {
        String notice = "(" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ")"
                + account + ":" + message;
        if (noticeSet.size() >= 20){
            Iterator<String> iterator = noticeSet.iterator();
            if (iterator.hasNext())
               noticeSet.remove(iterator.next());
        }
        noticeSet.add(notice);
        context.setAttribute("notice",message);
    }

    /**
     * 获取通知
     *
     * @return
     */
    @GetMapping("/getNotice")
    @ResponseBody
    public Object getNotice() {
        return noticeSet;
    }

}
