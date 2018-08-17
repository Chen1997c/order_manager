package com.blank.dto;

import java.io.Serializable;

/**
 * <p>
 *     功能描述:订单内容数据传输对象
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.16
 */
public class OrderContentDto implements Serializable {

    private static final long serialVersionUID = -2396210789642281833L;

    //order_content主键
    private Integer oc_id;

    //订单号
    private Integer oc_order_id;

    //单个菜品数量
    private Integer oc_dishNo;

    //桌号
    private Integer o_table_id;

    //菜名
    private String d_name;

    //价格
    private float d_price;

    //订单内容状态
    private Integer oc_state_id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOc_id() {
        return oc_id;
    }

    public void setOc_id(Integer oc_id) {
        this.oc_id = oc_id;
    }

    public Integer getOc_order_id() {
        return oc_order_id;
    }

    public void setOc_order_id(Integer oc_order_id) {
        this.oc_order_id = oc_order_id;
    }

    public Integer getOc_dishNo() {
        return oc_dishNo;
    }

    public void setOc_dishNo(Integer oc_dishNo) {
        this.oc_dishNo = oc_dishNo;
    }

    public Integer getO_table_id() {
        return o_table_id;
    }

    public void setO_table_id(Integer o_table_id) {
        this.o_table_id = o_table_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public Integer getOc_state_id() {
        return oc_state_id;
    }

    public void setOc_state_id(Integer oc_state_id) {
        this.oc_state_id = oc_state_id;
    }

    public float getD_price() {
        return d_price;
    }

    public void setD_price(float d_price) {
        this.d_price = d_price;
    }
}
