package com.ueumd.tech.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ueumd.tech.common.exception.ExceptionCode;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = -943143895792475225L;
    private static final int SUCCESS = 0;
    private static final String SUCCESS_MSG = "Succeed";

    /**
     * 状态码
     */
    private int code;
    private String message;
    private T data;
    private String traceId;

    public ResponseDTO() {
        this.code = SUCCESS;
        this.message = SUCCESS_MSG;
    }

    public ResponseDTO(ExceptionCode exceptionCode) {
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }

    public ResponseDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseDTO(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(T data) {
        this.code = SUCCESS;
        this.message = SUCCESS_MSG;
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String toString() {
        return "ResponseDTO [code=" + this.code + ", message=" + this.message + ", data=" + this.data + "]";
    }
}
