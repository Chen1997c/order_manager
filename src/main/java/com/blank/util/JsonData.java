package com.blank.util;

import com.blank.util.enums.EditEnum;

import java.io.Serializable;

/**
 * <p>
 *     功能描述: 返回JSON时数据封装类
 * </p>
 *
 * @author :Team Blank
 * @date :2018.08.06
 */
public class JsonData implements Serializable {

    private static final long serialVersionId = 1L;

    // 返回状态码 1表示成功
    private int code;
    private Object data;
    private String message;

    /**
     * 成功信息 包括状态码 消息 数据
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static JsonData buidSuccess(int code,String message,Object data) {
        return new JsonData(code,data,message);
    }

    /**
     * 成功信息 包括状态码和消息
     *
     * @param code
     * @param message
     * @return
     */
    public static JsonData buidSuccess(int code,String message) {
        return new JsonData(code,null,message);
    }

    /**
     * 失败信息 包括状态码和消息
     *
     * @param code
     * @param message
     * @return
     */
    public static JsonData bulidError(int code,String message) {
        return new JsonData(code,null,message);
    }

    /**
     * 统一返回对db中增、改、查的处理结果
     *
     * @param result
     * @return
     */
    public static Object jsonDataResult(Integer result) {
        if (result != null)
            return JsonData.buidSuccess(1, EditEnum.SUCCESS.getStateInfo());
        return JsonData.bulidError(0,EditEnum.FAIL.getStateInfo());
    }


    public JsonData(){

    }

    public JsonData(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String messsage) {
        this.message = messsage;
    }
}
