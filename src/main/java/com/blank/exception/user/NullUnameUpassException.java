package com.blank.exception.user;

/**
 * <p>
 *     功能描述:自定义登录用户名或者密码为空时异常
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.08
 */
public class NullUnameUpassException extends RuntimeException{

    public NullUnameUpassException() {
    }

    public NullUnameUpassException(String message) {
        super(message);
    }
}
