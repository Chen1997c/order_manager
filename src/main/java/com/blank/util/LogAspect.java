package com.blank.util;

import com.blank.util.enums.EditEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 功能描述:全局日志打印类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.09
 */
@Aspect
@Order(1)
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private HttpServletRequest request;

    //定义service实现类切入点
    @Pointcut("execution(* com.blank.service.impl.*.*(..))")
    public void serviceLog() {
    }

    //定义controller切入点
    @Pointcut("execution(* com.blank.controller.*.*.*(..))")
    public void controllerLog() {
    }

    /**
     * 环绕监听service层
     *
     * @param joinPoint
     * @return
     */
    @Around("serviceLog()")
    public Object serviceLog(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        try {
            logger.info("\n\n =============== {} ---> {} 执行 =============== \n", className, methodName);
            Object o = joinPoint.proceed();
            logger.info("\n\n =============== {} ---> {} 完成 =============== \n", className, methodName);
            return o;
        } catch (Throwable throwable) {
            logger.error("\n\n =============== {} ---> {} 异常 =============== \n", className, methodName);
            logger.error("异常信息 ---> \n", throwable);
        }
        return null;
    }


    /**
     * 环绕监听controller层
     *
     * @param joinPoint
     * @return
     */
    @Around("controllerLog()")
    public Object controllerLog(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        try {
            //该请求为定时发送,避免日志冗杂
            if (!"getNotice".equals(methodName))
                logger.info("\n\n =============== {} ---> {} 执行 =============== \n", className, methodName);
            Object o = joinPoint.proceed();
            if (IsAjaxUtil.isAjax(request)) {
                if (!"getNotice".equals(methodName))
                    logger.info("\n\n =============== {} ---> {} 返回json数据 =============== \n", className, methodName);
            } else {
                logger.info("\n\n =============== {} ---> {} 返回视图 =============== \n", className, methodName);
            }
            return o;
        } catch (Throwable throwable) {
            logger.error("\n\n =============== {} ---> {} 异常 =============== \n", className, methodName);
            logger.error("异常信息 ---> \n", throwable);
            if(IsAjaxUtil.isAjax(request)) {
                return JsonData.bulidError(0,EditEnum.FAIL.getStateInfo());
            }else {
                return "500";
            }
        }
    }
}
