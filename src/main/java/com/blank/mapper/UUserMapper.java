package com.blank.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blank.dto.UserDto;
import com.blank.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *     功能描述:员工mapper接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
@Mapper
public interface UUserMapper{

    User queryByUaccount(String account);

    Integer addUser(User user);

    Integer delById(Integer id);

    Integer update(User user);

    Integer updatePassword(User user);

    List<UserDto> searchByName(Pagination page,@Param("u_name") String u_name);

    Integer updateImg(@Param("url") String url, @Param("id") Integer id);

    Integer getCount(@Param("u_name") String u_name);
}
