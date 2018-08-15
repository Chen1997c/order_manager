package com.blank.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 *     功能描述:菜品实体类
 *     对应表:dc_dish
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.09
 */
public class Dish implements Serializable{

    private static final long serialVersionUID = -2556555327342355970L;
    private Integer d_id;
    private String d_name;
    private String d_description;
    private String d_txt;
    private String d_img;
    private String d_isGood;
    private float d_price;

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_description() {
        return d_description;
    }

    public void setD_description(String d_description) {
        this.d_description = d_description;
    }

    public String getD_txt() {
        return d_txt;
    }

    public void setD_txt(String d_txt) {
        this.d_txt = d_txt;
    }

    public String getD_img() {
        return d_img;
    }

    public void setD_img(String d_img) {
        this.d_img = d_img;
    }

    public String getD_isGood() {
        return d_isGood;
    }

    public void setD_isGood(String d_isGood) {
        this.d_isGood = d_isGood;
    }

    public float getD_price() {
        return d_price;
    }

    public void setD_price(float d_price) {
        this.d_price = d_price;
    }
}
