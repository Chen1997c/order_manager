package com.blank.mapper;

import com.blank.dto.OrderContentDto;
import com.blank.entity.OrderContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    List<OrderContentDto> getUnCookOrder();

    Integer setCookStateById(Integer oc_id);

    Integer setPublishStateById(Integer oc_id);

    Integer delById(Integer oc_id);

    Integer delByOId(Integer o_id);
}
