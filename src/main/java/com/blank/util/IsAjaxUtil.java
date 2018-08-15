package com.blank.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *     功能描述:判断是否是ajax请求
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.10
 */
public class IsAjaxUtil {

    /**
     * 是ajax 返回true
     *
     * @param request
     * @return
     */
    public static Boolean isAjax(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equals(requestType))
            return true;
        return false;
    }
}
