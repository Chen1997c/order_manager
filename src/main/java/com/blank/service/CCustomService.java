package com.blank.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.blank.entity.Custom;

/**
 * <p>
 *     功能描述:客户业务接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.11
 */
public interface CCustomService {

    /**
     * 查询全部
     *
     * @param current 当前页
     * @param pageSize 分页大小
     * @param c_name 按用户名查询
     * @return
     */
    Page<Custom> getCustoms(Integer current,Integer pageSize,String c_name);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer delById(Integer id);

    /**
     * 添加
     *
     * @param custom
     * @return
     */
    Integer addCustom(Custom custom);

    /**
     * 更新
     *
     * @param custom
     * @return
     */
    Integer updateCustom(Custom custom);
}
