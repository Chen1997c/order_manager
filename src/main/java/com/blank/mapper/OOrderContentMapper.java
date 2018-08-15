package com.blank.mapper;

import com.blank.entity.OrderContent;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *     功能描述:订单内容mapper接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
@Mapper
public interface OOrderContentMapper {

    Integer addOrderContent(OrderContent orderContent);
}
