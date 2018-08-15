package com.blank.mapper;

import com.blank.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

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
}
