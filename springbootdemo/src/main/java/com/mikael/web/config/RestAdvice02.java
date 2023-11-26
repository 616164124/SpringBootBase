package com.mikael.web.config;


import com.mikael.utils.exception.DefineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestAdvice02 {
    private static final Logger Log = LoggerFactory.getLogger(RestAdvice02.class);

    /**
     * 获取到异常转到这个页面
     * @param e
     * @return
     */
    @ExceptionHandler(DefineException.class)
    public String handleException(DefineException e) {
        Log.info("handleException========"+e);
        return "redirect:/error.html";
    }

    public static void main(String[] args) {
        
    }
}
