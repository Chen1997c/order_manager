package com.blank.mapper;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blank.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *     功能描述:菜品mapper接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
@Mapper
public interface DDishMaper extends BaseMapper<Dish> {

    List<Dish> getDishes(Pagination page, @Param("d_name") String d_name);

    Integer delById(Integer id);

    Integer updateDish(Dish dish);

    Integer updateDishImg(@Param("url") String url, @Param("id") Integer id);

    Integer addDish(Dish dish);

    List<Dish> getAll();

    Integer getCount(@Param("d_name")String d_name);

}
