package com.blank.mapper;

import com.blank.entity.Table;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *     功能描述:餐桌mapper接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.15
 */
@Mapper
public interface TTableMapper {

    List<Table> queryAll();

    Integer queryIsUsed(Integer dt_id);

    Table queryByNumber(Integer table_number);

    Integer addTable(Integer table_number);
}
