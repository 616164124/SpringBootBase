/**
 * projectName: SpringBootBase   
 * fileName: Beauty.java  
 * packageName: com.example.mikael.entity.beauty   
 * date: 2020-10-21
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.entity.beauty;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @version: V1.0
 * @author: mikael
 * @className: Beauty
 * @packageName: com.example.mikael.entity.beauty
 * @description:
 * @data: 2020-10-21
 **/
@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class Beauty implements Serializable {
    private int id;
    private String name;
    private char sex;
    private Date borndate;
    private String phone;
    private String photo;
    private int boyfriend_id;

}
