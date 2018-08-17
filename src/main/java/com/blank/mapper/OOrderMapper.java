package com.blank.mapper;

import com.blank.dto.DishDto;
import com.blank.dto.OrderDto;
import com.blank.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *     功能描述:订单mapper接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
@Mapper
public interface OOrderMapper {

    Integer addOrder(Order order);

    List<OrderDto> getOrdersInfo();

    Integer delById(Integer o_id);

    Integer setPayState(@Param("id") Integer o_id, @Param("endTime") Date date);

    Integer getSumRecentWeek(Integer beforeDay);

    List<DishDto> getHotDish();
}
