package com.ueumd.tech.common.exception;


public enum ExceptionCode {

    SYSTEM_ERROR(700, "系统错误"),

    FEIGN_ERROR(701, "feign相关错误"),

    BUSINESS_ERROR(702, "业务异常"),

    LOGIN_ERROR(80820001, "不存在的用户或错误的密码"),

    USER_NOT_EXIST(80820002, "用户不存在"),

    USER_NOT_ACTIVE(80820003, "账号未激活"),

    USER_DISABLED(80820004, "账号已注销"),

    TRANSLATE_TEXT_ERROR(80820005, "翻译异常"),

    AUDIO_TO_TEXT_ERROR(80820006, "音频转文本异常"),

    TEXT_TO_AUDIO_ERROR(80820006, "文本转语音异常"),

    FILE_FORM_ERROR(80820007, "文件格式有误"),
    ;



    private int code;

    private String message;

    public int getCode() {
        return code;
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

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
