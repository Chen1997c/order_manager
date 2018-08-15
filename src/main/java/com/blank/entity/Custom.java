package com.blank.entity;

import java.io.Serializable;

/**
 * <p>
 *     功能描述:客户实体表
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.11
 */
public class Custom implements Serializable{

    private static final long serialVersionUID = 532634982411121759L;
    private Integer c_id;
    private String c_name;
    private String c_sex;
    private String c_phoneNo;
    private Integer c_dinningTimes;
    private float c_dinningSum;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_sex() {
        return c_sex;
    }

    public void setC_sex(String c_sex) {
        this.c_sex = c_sex;
    }

    public String getC_phoneNo() {
        return c_phoneNo;
    }

    public void setC_phoneNo(String c_phoneNo) {
        this.c_phoneNo = c_phoneNo;
    }

    public Integer getC_dinningTimes() {
        return c_dinningTimes;
    }

    public void setC_dinningTimes(Integer c_dinningTimes) {
        this.c_dinningTimes = c_dinningTimes;
    }

    public float getC_dinningSum() {
        return c_dinningSum;
    }

    public void setC_dinningSum(float c_dinningSum) {
        this.c_dinningSum = c_dinningSum;
    }
}
