package com.blank.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.blank.entity.Dish;

import java.util.List;


/**
 * * <p>
 * *     功能描述:菜品业务接口
 * * </p>
 * *
 * * @author :Team Blank
 * * @since: :2018.08.09
 */
public interface DDishService {

    /**
     * 查询全部
     * current:分页 当前页
     * pageSize:每页显示记录数
     * u_name:按名字搜索
     *
     * @param current
     * @param pageSize
     * @param d_name
     * @return
     */
    Page<Dish> getDishes(Integer current, Integer pageSize, String d_name);

    /**
     * 获取全部dish
     *
     * @return
     */
    List<Dish> getAll();

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer delById(Integer id);

    /**
     * 更新
     *
     * @param dish
     * @return
     */
    Integer updateDish(Dish dish);

    Integer updateDishImg(String url, Integer id);

    /**
     * 添加
     *
     * @param dish
     * @return
     */
    Integer addDish(Dish dish);

}
