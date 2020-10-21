/**
 * projectName: SpringBootBase   
 * fileName: ExceptionHandlerAdvice.java  
 * packageName: com.example.mikael.controller.exceptioncontroller   
 * date: 2020-10-20
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.controller.exceptioncontroller;

import com.example.mikael.annotation.BaseResponse;
import com.example.mikael.exception.BaseException;
import com.example.mikael.response.ResponseCode;
import com.example.mikael.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version: V1.0
 * @author: mikael
 * @className: ExceptionHandlerAdvice
 * @packageName: com.example.mikael.controller.exceptioncontroller
 * @description:
 * @data: 2020-10-20
 **/
@ControllerAdvice(annotations = BaseResponse.class)
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(), ResponseCode.SERVICE_ERROR.getMsg(), null);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseResult handleBaseException(BaseException e) {
        log.error(e.getMessage());
        ResponseCode code = e.getCode();
        return new ResponseResult(code.getCode(), e.getMessage(), null);
    }
}
