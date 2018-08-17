package com.blank.service.impl;

import com.blank.dto.DishDto;
import com.blank.dto.OrderContentDto;
import com.blank.dto.OrderDto;
import com.blank.entity.Order;
import com.blank.entity.OrderContent;
import com.blank.mapper.OOrderContentMapper;
import com.blank.mapper.OOrderMapper;
import com.blank.mapper.TTableMapper;
import com.blank.service.OOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 功能描述:订单业务实现类
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

    @Resource
    private TTableMapper tableMapper;

    @Transactional
    @Override
    public Integer placeOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setO_waiter_id(orderDto.getO_waiter_id());
        order.setO_table_id(orderDto.getO_table_id());
        order.setO_beginTime(new Date());
        Integer result = orderMapper.addOrder(order);
        //更新餐桌状态信息===>使用中
        tableMapper.updateIsUsed(orderDto.getO_table_id(), 0);
        //获取自增的id
        Integer o_id = order.getO_id();
        System.out.println(o_id);
        for (OrderContent orderContent : orderDto.getOrderContents()) {
            orderContent.setOc_order_id(o_id);
            result += orderContentMapper.addOrderContent(orderContent);
        }
        return result;
    }

    @Override
    public List<OrderContentDto> getUnCookOrder() {
        return orderContentMapper.getUnCookOrder();
    }

    @Override
    public Integer cookById(Integer oc_id) {
        return orderContentMapper.setCookStateById(oc_id);
    }

    @Override
    public Integer publishById(Integer oc_id) {
        return orderContentMapper.setPublishStateById(oc_id);
    }

    @Override
    public Integer deleteContentById(Integer oc_id) {
        return orderContentMapper.delById(oc_id);
    }

    @Override
    public List<OrderDto> getOrdersInfo() {
        return orderMapper.getOrdersInfo();
    }

    @Transactional
    @Override
    public Integer delteOrderById(Integer o_id) {
        Integer result = orderContentMapper.delByOId(o_id);
        result += orderMapper.delById(o_id);
        return result;
    }

    @Transactional
    @Override
    public Integer payOrder(Integer o_id,Integer table_id) {
        Integer result = orderMapper.setPayState(o_id, new Date());
        result += tableMapper.setUnUsedById(table_id);
        return result;
    }

    @Override
    public List<Integer> getSumRecentWeek() {
        List<Integer> totlaList = new ArrayList<>();
        for (int i = 7; i > 0; i--) {
            if (i != 1) {
                Integer count1 = orderMapper.getSumRecentWeek(i);
                Integer count2 = orderMapper.getSumRecentWeek(i - 1);
                if (count1 != null && count2 != null) {
                    Integer count = count1 - count2;
                    totlaList.add(count);
                } else {
                    totlaList.add(0);
                }
            } else {
                Integer count = orderMapper.getSumRecentWeek(i);
                if (count != null) {
                    totlaList.add(count);
                } else {
                    totlaList.add(0);
                }
            }
        }
        return totlaList;
    }

    @Override
    public List<DishDto> getHotDishes() {
        return orderMapper.getHotDish();
    }

}
