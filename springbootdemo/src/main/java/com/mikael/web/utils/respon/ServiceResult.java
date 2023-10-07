package com.mikael.web.utils.respon;

import java.io.Serializable;

public class ServiceResult implements Serializable {
    private Integer code;
    private String msg;
    private Object obj;

    public ServiceResult(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public ServiceResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "code=" + code +
                ", msg=\"" + msg + '\"' +
                ", obj=" + obj +
                '}';
    }
}
