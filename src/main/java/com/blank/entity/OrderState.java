package com.blank.entity;

/**
 * <p>
 *     功能描述:订单状态实体类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
public class OrderState {

    private Integer os_id;
    private String os_name;

    public Integer getOs_id() {
        return os_id;
    }

    public void setOs_id(Integer os_id) {
        this.os_id = os_id;
    }

    public String getOs_name() {
        return os_name;
    }

    public void setOs_name(String os_name) {
        this.os_name = os_name;
    }
}
