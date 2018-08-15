package com.blank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * <p>
 *     功能描述:员工实体类
 *     对应表:dc_user
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
public class User implements Serializable {

    private static final long serialVersionUID = -828981573901599908L;
    private Integer u_id;
    private String u_account;
    @JsonIgnore
    private String u_password;
    private String u_isLocked;
    private String u_faceImg;
    private String u_name;
    private String u_sex;
    private String u_phoneNo;
    private String u_address;
    private Integer u_position_id;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_account() {
        return u_account;
    }

    public void setU_account(String u_account) {
        this.u_account = u_account;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_isLocked() {
        return u_isLocked;
    }

    public void setU_isLocked(String u_isLocked) {
        this.u_isLocked = u_isLocked;
    }

    public String getU_faceImg() {
        return u_faceImg;
    }

    public void setU_faceImg(String u_faceImg) {
        this.u_faceImg = u_faceImg;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_sex() {
        return u_sex;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_phoneNo() {
        return u_phoneNo;
    }

    public void setU_phoneNo(String u_phoneNo) {
        this.u_phoneNo = u_phoneNo;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public Integer getU_position_id() {
        return u_position_id;
    }

    public void setU_position_id(Integer u_position_id) {
        this.u_position_id = u_position_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_account='" + u_account + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_isLocked=" + u_isLocked +
                ", u_faceImg='" + u_faceImg + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_sex=" + u_sex +
                ", u_phoneNo='" + u_phoneNo + '\'' +
                ", u_address='" + u_address + '\'' +
                ", u_position_id=" + u_position_id +
                '}';
    }
}
