package com.blank.service;

import com.blank.dto.OrderDto;
import com.blank.entity.Order;
import com.blank.entity.OrderContent;

import java.util.List;

/**
 * <p>
 *     功能描述:订单业务接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
public interface OOrderService {

    /**
     * 下订单
     *
     * @param orderDto
     * @return
     */
    Integer placeOrder(OrderDto orderDto);

}
