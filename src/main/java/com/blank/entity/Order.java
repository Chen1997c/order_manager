package com.blank.entity;

import java.util.Date;

/**
 * <p>
 *     功能描述:订单实体类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
public class Order {

    private Integer o_id;
    private Date o_beginTime;
    private Date o_endTime;
    private Integer o_state_id;
    private Integer o_waiter_id;
    private Integer o_table_id;

    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }

    public Date getO_beginTime() {
        return o_beginTime;
    }

    public void setO_beginTime(Date o_beginTime) {
        this.o_beginTime = o_beginTime;
    }

    public Date getO_endTime() {
        return o_endTime;
    }

    public void setO_endTime(Date o_endTime) {
        this.o_endTime = o_endTime;
    }

    public Integer getO_state_id() {
        return o_state_id;
    }

    public void setO_state_id(Integer o_state_id) {
        this.o_state_id = o_state_id;
    }

    public Integer getO_waiter_id() {
        return o_waiter_id;
    }

    public void setO_waiter_id(Integer o_waiter_id) {
        this.o_waiter_id = o_waiter_id;
    }

    public Integer getO_table_id() {
        return o_table_id;
    }

    public void setO_table_id(Integer o_table_id) {
        this.o_table_id = o_table_id;
    }
}
