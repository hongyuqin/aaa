package com.kingdee.attendance.exception;

/**
 * @author hongyuqin
 * @since 2018/9/20  下午12:29
 */
public class TrajectoryException extends RuntimeException {
    private int errorCode;

    private String errorMsg;

    public TrajectoryException() {
        super();
    }

    public TrajectoryException(String message) {
        super(message);
        this.errorMsg = message;
    }

    public TrajectoryException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = message;
    }

    public String getErrorMsg(){
        return this.errorMsg;
    }

    public int getErrorCode(){
        return this.errorCode;
    }
}
