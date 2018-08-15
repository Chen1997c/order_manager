package com.blank.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blank.dto.UserDto;
import com.blank.entity.User;
import com.blank.mapper.UUserMapper;
import com.blank.mapper.UUserPositionMapper;
import com.blank.service.UUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 功能描述:员工业务实现类
 * </p>
 *
 * @author :Team Blank
 * @since: 2018.08.06
 */
@Service
public class UUserServiceImpl implements UUserService {

    @Resource
    private UUserMapper userMapper;

    @Resource
    private UUserPositionMapper userPositionMapper;

    @Override
    public User login(String account) {
        return userMapper.queryByUaccount(account);
    }

    @Override
    public Set<String> getPositionsByUaccount(String account) {
        int role_id = userMapper.queryByUaccount(account).getU_position_id();
        Set<String> roles = userPositionMapper.getPositionsById(role_id);
        return roles;
    }

    @Override
    public Integer add(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer delById(Integer id) {
        return userMapper.delById(id);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

    @Override
    public Integer resetPassword(User user) {
        return userMapper.updatePassword(user);
    }

    @Override
    public Page<UserDto> searchByName(Integer current, Integer pageSize, String u_name) {
        Page<UserDto> pages = new Page<>(current, pageSize);
        //注入total 避免缓存数据后total为0
        pages.setTotal(userMapper.getCount(u_name));
        return pages.setRecords(userMapper.searchByName(pages, u_name));
    }

    @Override
    public Integer updateAvatar(String url, Integer id) {
        return userMapper.updateImg(url, id);
    }


}
