package com.blank.shiro;

import com.blank.entity.User;
import com.blank.exception.user.NullUnameUpassException;
import com.blank.util.enums.LoginEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Component;


/**
 * <p>
 * 功能描述:token管理器
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
@Component
public class TokenManager {

    /**
     * 登录
     *
     * @param user
     */
    public void subLogin(User user) {
        if (user.getU_password() != null && user.getU_account() != null) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getU_account(), user.getU_password());
            try {
                Subject subject = SecurityUtils.getSubject();
                subject.login(token);
            } catch (IncorrectCredentialsException e1) {
                throw new IncorrectCredentialsException(LoginEnum.ERROR_PASSWORD.getStateInfo());
            } catch (LockedAccountException e2) {
                throw new LockedAccountException(LoginEnum.LOCKED_ACOUNT.getStateInfo());
            } catch (UnknownAccountException e3) {
                throw new UnknownAccountException(LoginEnum.NOT_EXIST_ACCOUNT.getStateInfo());
            }
        } else {
            throw new NullUnameUpassException(LoginEnum.NULL_UnameUpass.getStateInfo());
        }
    }

    /**
     * 登出
     */
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        String account = (String) subject.getPrincipal();
        subject.logout();
        return account;
    }

}
