package com.blank.entity;

import java.io.Serializable;

/**
 * <p>
 *     功能描述:员工职位实体类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
public class UserPosition implements Serializable{

    private static final long serialVersionUID = -2869113166144693525L;
    private Integer id;
    private String position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
