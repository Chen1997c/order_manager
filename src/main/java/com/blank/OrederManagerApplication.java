package com.blank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 *     功能描述:应用程序的入口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.10
 */
@SpringBootApplication
@EnableTransactionManagement
public class OrederManagerApplication {

    public static void main(String[] args) {
        //启动应用
        SpringApplication.run(OrederManagerApplication.class, args);
    }
}
