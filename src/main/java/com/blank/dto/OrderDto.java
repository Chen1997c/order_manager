package com.blank.dto;

import com.blank.entity.OrderContent;

import java.io.Serializable;
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

    //对应order表o_waiter_id
    private Integer o_waiter_id;
    //对应order表o_waiter_id
    private Integer o_table_id;

    //多个orderContent
    private List<OrderContent> orderContents;

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

    @Override
    public String toString() {
        return "OrderDto{" +
                "o_waiter_id=" + o_waiter_id +
                ", o_table_id=" + o_table_id +
                ", orderContents=" + orderContents +
                '}';
    }
}
