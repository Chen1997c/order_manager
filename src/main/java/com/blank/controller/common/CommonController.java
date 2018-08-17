package com.blank.controller.common;

import com.blank.controller.BaseController;
import com.blank.entity.User;
import com.blank.exception.user.NullUnameUpassException;
import com.blank.service.UUserService;
import com.blank.shiro.TokenManager;
import com.blank.util.JsonData;
import com.blank.util.VerifyCodeUtil;
import com.blank.util.enums.EditEnum;
import com.blank.util.enums.LoginEnum;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 * 功能描述:公共部分控制器
 * </p>
 */
@Controller
public class CommonController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UUserService userService;

    /**
     * 转到登录页面
     *
     * @return
     */
    @RequestMapping("/login.html")
    public String loginView() {
        return "public/login";
    }

    /**
     * 获取图片验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/VCodeImg")
    public void getVerifyCodeImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCodeUtil.outputCode(request, response);
    }

    /**
     * 获得通知
     *
     * @return
     */
    @RequestMapping("/getNotice")
    @ResponseBody
    public Object getNotice() {
        String notice = (String) session.getAttribute("notice");
        return notice;
    }

    /**
     * 处理登录请求
     *
     * @param user
     * @param verifyCode
     * @return
     */
    @PostMapping(value = "/subLogin")
    @ResponseBody
    public Object doLogin(User user, String verifyCode) {
        String code = (String) session.getAttribute("verifyCode");
        if (verifyCode.equalsIgnoreCase(code)) {
            try {
                tokenManager.subLogin(user);
                User current_user = userService.login(user.getU_account());
                session.setAttribute("current_user",current_user);
                return JsonData.buidSuccess(1, LoginEnum.SUCCESS.getStateInfo(),current_user);
            } catch (IncorrectCredentialsException e1) {
                logger.info("\n\n ******** CommonController =====> doLogin 帐号:{} 密码错误 ******** \n", user.getU_account());
                return JsonData.bulidError(0, e1.getMessage());
            } catch (LockedAccountException e2) {
                logger.info("\n\n ******** CommonController =====> doLogin 帐号:{} 已被锁定 ******** \n", user.getU_account());
                return JsonData.bulidError(0, e2.getMessage());
            } catch (UnknownAccountException e3) {
                logger.info("\n\n ******** CommonController =====> doLogin 帐号:{} 该账号不存在 ******** \n", user.getU_account());
                return JsonData.bulidError(0, e3.getMessage());
            } catch (NullUnameUpassException e4) {
                logger.info("\n\n ******** CommonController =====> doLogin 帐号或者密码为空 ******** \n");
                return JsonData.bulidError(0, e4.getMessage());
            }
        } else {
            logger.info("\n\n ******** CommonController =====> doLogin 验证码输入错误 ******** \n");
            return JsonData.bulidError(-1, LoginEnum.ERROR_VerifyCode.getStateInfo());
        }
    }

    /**
     * 登出
     *
     * @return
     */
    @GetMapping("/logout")
    @ResponseBody
    public Object logout() {
        try {
            String account = tokenManager.logout();
            logger.info("\n\n ******** CommonController =====> logout {} 登出 ******** \n",account);
            return JsonData.buidSuccess(1,EditEnum.SUCCESS.getStateInfo());
        }catch (Exception e) {
            return JsonData.bulidError(0,EditEnum.FAIL.getStateInfo());
        }
    }
}
