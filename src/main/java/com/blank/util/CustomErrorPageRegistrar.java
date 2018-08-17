package com.blank.util;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/**
 * <p>
 *     功能描述:错误界面注册器
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.17
 *
 */
public class CustomErrorPageRegistrar implements ErrorPageRegistrar {


    /**
     * 注册错误界面
     *
     * @param registry
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/error/404"));
        registry.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500"));
    }
}
