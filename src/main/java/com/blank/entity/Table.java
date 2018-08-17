package com.blank.entity;


import java.io.Serializable;

/**
 * <p>
 *     功能描述:餐桌实体类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.15
 */
public class Table implements Serializable {

    private static final long serialVersionUID = -5499783296711351304L;
    private Integer dt_id;
    private Integer dt_table_number;
    private Integer dt_isUsing;

    public Integer getDt_id() {
        return dt_id;
    }

    public void setDt_id(Integer dt_id) {
        this.dt_id = dt_id;
    }

    public Integer getDt_table_number() {
        return dt_table_number;
    }

    public void setDt_table_number(Integer dt_table_number) {
        this.dt_table_number = dt_table_number;
    }

    public Integer getDt_isUsing() {
        return dt_isUsing;
    }

    public void setDt_isUsing(Integer dt_isUsing) {
        this.dt_isUsing = dt_isUsing;
    }
}
