package com.mikael.utils.respon;

import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public  class ResultUtil {


    public static ServiceResult put(Integer integer, String msg, Object o) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(integer);
        serviceResult.setMsg(msg);
        serviceResult.setObj(o);
        return serviceResult;
    }

    public static ServiceResult error() {
        ServiceResult serviceResult = put(Integer.getInteger(CodeEnum.ERROR.getCode()), CodeEnum.ERROR.getMsg(), null);
        return serviceResult;
    }

    public static ServiceResult success(){
        ServiceResult serviceResult = put(Integer.getInteger(CodeEnum.SUCCESS200.getCode()), CodeEnum.SUCCESS.getMsg(), null);
        return serviceResult;
    }

    public  static  ServiceResult put(@NotNull CodeEnum codeEnum, Object o){
        ServiceResult serviceResult = put(Integer.getInteger(codeEnum.getCode()), codeEnum.getMsg(), o);
        return serviceResult;
    }

    public static void main(String[] args) {
        System.out.println(ResultUtil.error());
    }

}
