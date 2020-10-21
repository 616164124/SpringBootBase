/**
 * projectName: SpringBootBase   
 * fileName: BaseResponse.java  
 * packageName: com.example.mikael.annotation   
 * date: 2020-10-20
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version: V1.0
 * @author: stjh756
 * @className: BaseResponse
 * @packageName: com.example.mikael.annotation
 * @description:
 * @data: 2020-10-20
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface BaseResponse {
}
  