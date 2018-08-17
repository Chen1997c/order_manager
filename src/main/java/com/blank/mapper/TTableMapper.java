package com.blank.mapper;

import com.blank.entity.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PutMapping;

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

    Integer deleteById(Integer table_id);

    Integer updateIsUsed(@Param("dt_id") Integer dt_id, @Param("isUsed") Integer is_used);

    Integer setUnUsedById(Integer dt_id);
}
