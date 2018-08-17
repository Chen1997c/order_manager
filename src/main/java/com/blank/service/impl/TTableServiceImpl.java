package com.blank.service.impl;

import com.blank.entity.Table;
import com.blank.mapper.TTableMapper;
import com.blank.service.TTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 功能描述:餐桌业务实现类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.15
 */
@Service
public class TTableServiceImpl implements TTableService {


    @Resource
    private TTableMapper tableMapper;

    @Override
    public List<Table> getAllRecords() {
        return tableMapper.queryAll();
    }

    @Override
    public Integer checkTable(Integer dt_id) {
        return tableMapper.queryIsUsed(dt_id);
    }

    @Override
    public Integer addTable(Integer table_number) {
        Table table = tableMapper.queryByNumber(table_number);
        if (table != null)
            return -1;
        return tableMapper.addTable(table_number);
    }

    @Override
    public Integer removeTableById(Integer table_id) {
        return tableMapper.deleteById(table_id);
    }

    @Override
    public Integer updateIsUsed(Integer dt_id, Integer is_used) {
        return tableMapper.updateIsUsed(dt_id, is_used);
    }
}
