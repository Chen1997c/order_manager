package com.blank.dto;

import com.blank.entity.OrderContent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *      功能描述:订单数据传输对象
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
public class OrderDto implements Serializable {

    private static final long serialVersionUID = -3637663458775170605L;

    //订单号 主键
    private Integer o_id;

    //对应order表o_beginTime
    private Date o_beginTime;

    //对应order表o_endTime
    private Date o_endTime;

    //对应order表o_state_id
    private Integer o_state_id;

    //对应order表o_waiter_id
    private Integer o_waiter_id;
    //对应order表o_waiter_id
    private Integer o_table_id;

    //一个order多个orderContent
    private List<OrderContent> orderContents;

    //OrderContentDto包含菜品信息 做三表联合查询
    private List<OrderContentDto> orderContentDtos;

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

    public List<OrderContent> getOrderContents() {
        return orderContents;
    }

    public void setOrderContents(List<OrderContent> orderContents) {
        this.orderContents = orderContents;
    }


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

    public List<OrderContentDto> getOrderContentDtos() {
        return orderContentDtos;
    }

    public void setOrderContentDtos(List<OrderContentDto> orderContentDtos) {
        this.orderContentDtos = orderContentDtos;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "o_id=" + o_id +
                ", o_beginTime=" + o_beginTime +
                ", o_endTime=" + o_endTime +
                ", o_state_id=" + o_state_id +
                ", o_waiter_id=" + o_waiter_id +
                ", o_table_id=" + o_table_id +
                ", orderContents=" + orderContents +
                ", orderContentDtos=" + orderContentDtos +
                '}';
    }
}
