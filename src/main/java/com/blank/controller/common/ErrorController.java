package com.blank.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *     功能描述:错误页面控制器
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.17
 */
@RequestMapping("/error")
@Controller
public class ErrorController {

    @GetMapping("401.html")
    public String UnauthorizedError() {
        return "public/401";
    }

    @GetMapping("/404.html")
    public String notFoundError() {
        return "/public/404";
    }

    @GetMapping("/500.html")
    public String internalServerError() {
        return "/public/500";
    }
}
