package com.blank.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blank.entity.Dish;
import com.blank.mapper.DDishMaper;
import com.blank.service.DDishService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 功能描述:菜品业务实现类
 * </p>
 *
 * @author :Team Blank
 * @since: 2018.08.09
 */
@Service
public class DDishServiceImpl implements DDishService {

    @Resource
    private DDishMaper dishMaper;

    @Override
    public Page<Dish> getDishes(Integer current, Integer pageSize, String d_name) {
        Page<Dish> pages = new Page<>(current, pageSize);
        //注入total 避免缓存数据后total为0
        pages.setTotal(dishMaper.getCount(d_name));
        return pages.setRecords(dishMaper.getDishes(pages, d_name));
    }

    @Override
    public List<Dish> getAll() {
        return dishMaper.getAll();
    }

    @Override
    public Integer delById(Integer id) {
        return dishMaper.delById(id);
    }

    @Override
    public Integer updateDish(Dish dish) {
        return dishMaper.updateDish(dish);
    }

    @Override
    public Integer updateDishImg(String url, Integer id) {
        return dishMaper.updateDishImg(url, id);
    }

    @Override
    public Integer addDish(Dish dish) {
        return dishMaper.addDish(dish);
    }

}
