package com.blank.service;

import com.blank.entity.Table;

import java.util.List;

/**
 * <p>
 *     功能描述:餐桌业务接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.15
 */
public interface TTableService {

    /**
     * 获取全部餐桌
     *
     * @return
     */
    List<Table> getAllRecords();

    /**
     * 查看餐桌是否正在使用
     *
     * @param dt_id
     * @return
     */
    Integer checkTable(Integer dt_id);

    /**
     * 添加餐桌
     *
     * @param table_number
     * @return
     */
    Integer addTable(Integer table_number);
}
