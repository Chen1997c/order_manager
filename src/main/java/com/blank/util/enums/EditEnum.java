package com.blank.util.enums;

/**
 * <p>
 * 功能描述:通用返回消息枚举类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
public enum EditEnum {

    SUCCESS("成功"),
    FAIL("失败");

    //状态消息
    private String stateInfo;


    EditEnum() {
    }

    EditEnum(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
