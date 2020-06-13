package org.yuanding.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Error {

    USER_EMAIL_EXISTS(20001, "此邮箱已存在."),
    USER_NAME_EXISTS(20002, "此用户名已存在."),



    SERVER_INTERVAL_ERROR(50000, "服务器未知错误");


    private final int code;
    private final String message;

    private Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }


}
