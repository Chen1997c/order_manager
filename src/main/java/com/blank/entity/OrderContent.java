package com.blank.entity;

import java.io.Serializable;

/**
 * <p>
 *     功能描述:订单内容实体类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
public class OrderContent implements Serializable {

    private static final long serialVersionUID = 3198258928719547625L;
    private Integer oc_id;
    private Integer oc_dish_id;
    private Integer oc_dishNo;
    private Integer oc_order_id;

    public Integer getOc_id() {
        return oc_id;
    }

    public void setOc_id(Integer oc_id) {
        this.oc_id = oc_id;
    }

    public Integer getOc_dish_id() {
        return oc_dish_id;
    }

    public void setOc_dish_id(Integer oc_dish_id) {
        this.oc_dish_id = oc_dish_id;
    }

    public Integer getOc_dishNo() {
        return oc_dishNo;
    }

    public void setOc_dishNo(Integer oc_dishNo) {
        this.oc_dishNo = oc_dishNo;
    }

    public Integer getOc_order_id() {
        return oc_order_id;
    }

    public void setOc_order_id(Integer oc_order_id) {
        this.oc_order_id = oc_order_id;
    }

    @Override
    public String toString() {
        return "OrderContent{" +
                "oc_id=" + oc_id +
                ", oc_dish_id=" + oc_dish_id +
                ", oc_dishNo=" + oc_dishNo +
                ", oc_order_id=" + oc_order_id +
                '}';
    }
}
