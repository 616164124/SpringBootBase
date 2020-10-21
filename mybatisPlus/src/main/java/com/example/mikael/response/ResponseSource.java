/**
 * projectName: demo   
 * fileName: Response.java  
 * packageName: com.example.demo.response   
 * date: 2020-10-16
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.response;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: mikael
 * @className: Response
 * @packageName: com.example.demo.response
 * @description:
 * @data: 2020-10-16
 **/
public class ResponseSource<T> implements Serializable {
    private T data;
    private Meta meta;

    public ResponseSource(Meta meta, T data) {
        this.meta = meta;
        this.data = data;
    }

    public ResponseSource(T data) {
        this.meta = new Meta();
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


