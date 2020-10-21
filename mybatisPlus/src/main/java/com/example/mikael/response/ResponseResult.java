/**
 * projectName: SpringBootBase   
 * fileName: ResponseResult.java  
 * packageName: com.example.mikael.response   
 * date: 2020-10-20
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @version: V1.0
 * @author: mikael
 * @className: ResponseResult
 * @packageName: com.example.mikael.response
 * @description:
 * @data: 2020-10-20
 **/
@Data
@Getter
@Setter
@AllArgsConstructor
public class ResponseResult {
    private Integer code; //状态码
    private String message; // 信息
    private Object data; //数据
}
