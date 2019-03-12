package com.kingdee.attendance.dto;

import java.io.Serializable;

/**
 * 定义 API 返回的 Json 格式
 */
public class APIResponseJson implements Serializable {

    private static final long serialVersionUID = 942056662427916900L;

    public boolean success = true;
    public String errorMsg; // 错误时的信息
    public int errorCode; // 错误时的状态码
    public Object data; // 返回的 业务 json 数据

    public APIResponseJson() {
    }

    public APIResponseJson(boolean success, String errorMsg) {
        super();
        this.success = success;
        this.errorMsg = errorMsg;
    }

    public APIResponseJson(boolean success, Object data) {
        super();
        this.success = success;
        this.data = data;
    }

    public APIResponseJson(boolean success, String errorMsg, int errorCode, Object data) {
        this.success = success;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
        this.data = data;
    }

    public static APIResponseJson success() {
        return new APIResponseJson(true, null, ErrorCode.SUCCESS.key(), null);
    }

    public static APIResponseJson success(Object data) {
        return new APIResponseJson(true, null, ErrorCode.SUCCESS.key(), data);
    }

    public static APIResponseJson error(int errorCode, String errorMsg) {
        return new APIResponseJson(false, errorMsg, errorCode, null);
    }

    public static APIResponseJson error(ErrorCode errorCode) {
        return new APIResponseJson(false, errorCode.value(), errorCode.key(), null);
    }

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the errorMessage
     */

    public String getErrorMsg() {
        return errorMsg;
    }


    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

}