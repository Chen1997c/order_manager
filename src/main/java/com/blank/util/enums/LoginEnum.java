package com.blank.util.enums;

/**
 * <p>
 *     功能描述:登录返回消息枚举类
 * </p>
 *
 * @author :Team Blank
 * @date :2018.08.06
 */
public enum  LoginEnum {

    SUCCESS("登录成功"),
    LOCKED_ACOUNT("帐号被锁定"),
    NOT_EXIST_ACCOUNT("帐号不存在"),
    ERROR_PASSWORD("用户名或密码错误"),
    ERROR_VerifyCode("验证码错误"),
    NULL_UnameUpass("用户名或者密码不能为空");

    //消息
    private String stateInfo;

    LoginEnum(){}

    LoginEnum(String stateInfo){
        this.stateInfo = stateInfo;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
