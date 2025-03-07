package com.java.java.exception;

public enum ErrorCode {
    USER_EXISTED(400, "User exists")
    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
