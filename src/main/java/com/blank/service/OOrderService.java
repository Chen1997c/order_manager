package com.blank.service;

import com.blank.dto.DishDto;
import com.blank.dto.OrderContentDto;
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

    /**
     * 获取菜还没有炒的订单
     *
     * @return
     */
    List<OrderContentDto> getUnCookOrder();

    /**
     * 烹饪
     *
     * @param oc_id
     * @return
     */
    Integer cookById(Integer oc_id);

    /**
     * 传菜
     *
     * @param oc_id
     * @return
     */
    Integer publishById(Integer oc_id);

    /**
     * 删除订单内容
     *
     * @param oc_id
     * @return
     */
    Integer deleteContentById(Integer oc_id);

    /**
     * 获取全部订单信息
     *
     * @return
     */
    List<OrderDto> getOrdersInfo();

    /**
     * 删除订单 包括订单和订单内容
     *
     * @param o_id
     * @return
     */
    Integer delteOrderById(Integer o_id);

    /**
     * 支付订单
     *
     * @param o_id
     * @return
     */
    Integer payOrder(Integer o_id,Integer table_id);

    /**
     * 获取最近一周每日的销售额
     *
     * @return
     */
    List<Integer> getSumRecentWeek();

    /**
     * 获取热门菜(最多6种)
     *
     * @return
     */
    List<DishDto> getHotDishes();
}
