package com.blank.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.blank.entity.Custom;
import com.blank.mapper.CCustomMapper;
import com.blank.service.CCustomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 功能描述:客户业务实现类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.11
 */
@Service
public class CCustomServiceImpl implements CCustomService {

    @Resource
    private CCustomMapper customMapper;

    @Override
    public Page<Custom> getCustoms(Integer current, Integer pageSize, String c_name) {
        Page<Custom> pages = new Page<>(current, pageSize);
        //注入total 避免缓存数据后total为0
        pages.setTotal(customMapper.getCount(c_name));
        return pages.setRecords(customMapper.getCustoms(pages,c_name));
    }

    @Override
    public Integer delById(Integer id) {
        return customMapper.delById(id);
    }

    @Override
    public Integer addCustom(Custom custom) {
        return customMapper.addCustom(custom);
    }

    @Override
    public Integer updateCustom(Custom custom) {
        return customMapper.updateCustom(custom);
    }
}
