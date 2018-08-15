package com.blank.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.blank.entity.UserPosition;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * <p>
 *     功能描述:员工职位mapper接口
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
@Mapper
public interface UUserPositionMapper {

    Set<String> getPositionsById(Integer id);
}
