package com.blank.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.blank.dto.UserDto;
import com.blank.entity.User;

import java.util.List;
import java.util.Set;

/**
 * * <p>
 * *     功能描述:员工业务接口
 * * </p>
 * *
 * * @author :Team Blank
 * * @since: :2018.08.06
 */
public interface UUserService {


    /**
     * 根据用户名查询 进行登录
     *
     * @param account
     * @return
     */
    User login(String account);

    /**
     * 根据用户名获得角色信息
     *
     * @param account
     * @return
     */
    Set<String> getPositionsByUaccount(String account);


    /**
     * 添加
     *
     * @param user
     * @return
     */
    Integer add(User user);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer delById(Integer id);

    /**
     * 更新信息
     *
     * @param user
     * @return
     */
    Integer update(User user);

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    Integer resetPassword(User user);

    /**
     * 查询全部
     * current:分页 当前页
     * pageSize:每页显示记录数
     * u_name:按名字搜索
     *
     * @param current
     * @param pageSize
     * @param u_name
     * @return
     */
    Page<UserDto> searchByName(Integer current, Integer pageSize, String u_name);

    /**
     * 保存头像url
     *
     * @param url
     * @param id
     * @return
     */
    Integer updateAvatar(String url, Integer id);
}
