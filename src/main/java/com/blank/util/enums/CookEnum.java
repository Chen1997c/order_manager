package com.blank.util.enums;

/**
 * <p>
 *     功能描述:后厨操作返回消息枚举类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.17
 */
public enum  CookEnum {

    SUCCESS("操作成功"),
    COOK_FAIL("操作失败，请检查该菜品是否已经烹饪"),
    PUBLISH_FAIL("操作失败，请检查该菜品是否已传菜"),
    INNER_ERROR("操作失败,未知错误(错误码:100001)");

    //状态消息
    private String stateInfo;


    CookEnum() {
    }

    CookEnum(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
