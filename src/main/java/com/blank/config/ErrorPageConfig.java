package com.blank.config;

import com.blank.util.CustomErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *     功能描述:自定义错误指向页面
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.17
 */
@Configuration
public class ErrorPageConfig {

    //注入ErrorPageRegistrar
    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new CustomErrorPageRegistrar();
    }
}
