package com.blank.exception;

import com.blank.util.IsAjaxUtil;
import com.blank.util.JsonData;
import com.blank.util.enums.EditEnum;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     功能描述:处理全局异常
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
@RestControllerAdvice
public class HandlerException {


}
