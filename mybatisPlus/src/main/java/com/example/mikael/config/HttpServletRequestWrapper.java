package com.example.mikael.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: V1.0
 * @author: mikael
 * @className: HttpServletRequestWrapper
 * @packageName: com.example.mikael.config
 * @description:
 * @data: 2020-11-21
 **/
public class HttpServletRequestWrapper extends HttpRequestWrapper {

    public HttpServletRequestWrapper(HttpRequest request) {
        super(request);
        System.out.println("进入 HttpServletRequest");
    }
}
