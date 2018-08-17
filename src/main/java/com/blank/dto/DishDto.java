package com.blank.dto;

import java.io.Serializable;

/**
 * <p>
 *     功能描述:菜品数据传输对象
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
public class DishDto implements Serializable {

    private static final long serialVersionUID = -4358132869153171292L;
    private Integer d_id;
    private String d_name;
    private String d_description;
    private String d_txt;
    private String d_img;
    private String d_isGood;
    private float d_price;

    //订单中菜品数(前端发送过来的)
    private Integer count;

    //多个订单(按时间查询订单)中单个菜品的数量(返回给前端的)
    private Integer sumCount;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSumCount() {
        return sumCount;
    }

    public void setSumCount(Integer sumCount) {
        this.sumCount = sumCount;
    }
}
