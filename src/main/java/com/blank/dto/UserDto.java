package com.blank.dto;

import com.blank.entity.User;
import com.blank.entity.UserPosition;

import java.io.Serializable;

/**
 * <p>
 *      功能描述:用户数据传输对象
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.06
 */
public class UserDto implements Serializable {

    private static final long serialVersionUID = -204318607053632429L;

    private Integer u_id;
    private String u_account;
    private String u_name;
    private String u_sex;
    private String u_phoneNo;
    private String u_address;
    private String u_isLocked;
    private String u_faceImg;
    //多对一
    private UserPosition userPosition;

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

    public UserPosition getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(UserPosition userPosition) {
        this.userPosition = userPosition;
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
}
