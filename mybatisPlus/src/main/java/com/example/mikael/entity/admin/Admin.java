/**
 * projectName: SpringBootBase   
 * fileName: Admin.java  
 * packageName: com.example.mikael.entity.admin   
 * date: 2020-10-20
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.entity.admin;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: mikael
 * @className: Admin
 * @packageName: com.example.mikael.entity.admin
 * @description:
 * @data: 2020-10-20
 **/

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Admin {
    private Integer id;
    private String username;
    private String password;

}
