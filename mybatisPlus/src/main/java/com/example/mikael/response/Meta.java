/**
 * projectName: demo   
 * fileName: Meta.java  
 * packageName: com.example.demo.response   
 * date: 2020-10-16
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.response;

import java.io.Serializable;
import java.sql.ParameterMetaData;

public class Meta implements Serializable {
    private String msg;
    private int status;

    public Meta(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    /**
     * 默认为操作成功，status为200；
     */
    public Meta() {
        this.msg = "成功";
        this.status = 200;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                '}';
    }
}