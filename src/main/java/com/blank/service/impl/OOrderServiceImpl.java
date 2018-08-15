package com.blank.service.impl;

import com.blank.dto.OrderDto;
import com.blank.entity.Order;
import com.blank.entity.OrderContent;
import com.blank.mapper.OOrderContentMapper;
import com.blank.mapper.OOrderMapper;
import com.blank.service.OOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *     功能描述:订单业务实现类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
@Service
public class OOrderServiceImpl implements OOrderService {

    @Resource
    private OOrderMapper orderMapper;

    @Resource
    private OOrderContentMapper orderContentMapper;

    @Transactional
    @Override
    public Integer placeOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setO_waiter_id(orderDto.getO_waiter_id());
        order.setO_table_id(orderDto.getO_table_id());
        order.setO_beginTime(new Date());
        Integer result = orderMapper.addOrder(order);
        //获取自增的id
        Integer o_id = order.getO_id();
        System.out.println(o_id);
        for(OrderContent orderContent : orderDto.getOrderContents()){
            orderContent.setOc_order_id(o_id);
            result += orderContentMapper.addOrderContent(orderContent);
        }
        return result;
    }

}
