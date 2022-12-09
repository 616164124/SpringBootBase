package com.example.springsecurity.exceptionconfig;

import mikael.web.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationConfig {

    private static final Logger log = LoggerFactory.getLogger(ValidationConfig.class);

    @ExceptionHandler(Exception.class)
    public String reException(Exception e) {
    log.info(e.toString());
    return new ServiceResult().getResultMsg(e.getMessage());
    }
}
