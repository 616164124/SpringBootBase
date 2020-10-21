/**
 * projectName: SpringBootBase   
 * fileName: ResponseResultHandlerAdvice.java  
 * packageName: com.example.mikael.controller.exceptioncontroller   
 * date: 2020-10-20
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.controller.exceptioncontroller;

import com.example.mikael.annotation.BaseResponse;
import com.example.mikael.response.ResponseCode;
import com.example.mikael.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @version: V1.0
 * @author: mikael
 * @className: ResponseResultHandlerAdvice
 * @packageName: com.example.mikael.controller.exceptioncontroller
 * @description:
 * @data: 2020-10-20
 **/
@ControllerAdvice(annotations = BaseResponse.class)
@Slf4j
public class ResponseResultHandlerAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {

        log.info("returnType", returnType);
        log.info("converterType", converterType);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (MediaType.APPLICATION_JSON.equals(selectedContentType) || MediaType.APPLICATION_JSON_UTF8.equals(selectedContentType)) { // 判断响应的Content-Type为JSON格式的body
            if (body instanceof ResponseResult) { // 如果响应返回的对象为统一响应体，则直接返回body
                return body;
            } else {
                // 只有正常返回的结果才会进入这个判断流程，所以返回正常成功的状态码
                ResponseResult responseResult = new ResponseResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), body);
                return responseResult;
            }
        }
        // 非JSON格式body直接返回即可
        return body;
    }
}
