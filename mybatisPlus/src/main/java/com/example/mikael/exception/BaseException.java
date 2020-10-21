/**
 * projectName: SpringBootBase   
 * fileName: BaseException.java  
 * packageName: com.example.mikael.exception   
 * date: 2020-10-20
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.exception;

import com.example.mikael.response.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @version: V1.0
 * @author: mikael
 * @className: BaseException
 * @packageName: com.example.mikael.exception
 * @description:
 * @data: 2020-10-20
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends Exception {

    private ResponseCode code;

    public BaseException(ResponseCode code) {
        this.code = code;
    }

    public BaseException(Throwable throwable, ResponseCode code) {
        super(throwable);
        this.code = code;
    }

}
