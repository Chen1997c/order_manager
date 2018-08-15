package com.blank.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blank.entity.Custom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *     功能描述:顾客mapper接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.11
 */
@Mapper
public interface CCustomMapper {

    List<Custom> getCustoms(Pagination page, @Param("c_name") String c_name);

    Integer delById(Integer id);

    Integer addCustom(Custom custom);

    Integer updateCustom(Custom custom);

    Integer getCount(String c_name);
}
