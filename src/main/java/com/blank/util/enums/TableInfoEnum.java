package com.blank.util.enums;

/**
 * <p>
 *     功能描述:餐桌操作返回消息枚举
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.15
 */
public enum  TableInfoEnum {

    REPEAT("该餐桌号已经存在!"),
    INNER_ERROR("发生位置错误(错误码:-10000)"),
    SUCCESS("操作成功");

    //消息
    private String stateInfo;

    TableInfoEnum(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    TableInfoEnum() {
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
