/**
 * projectName: SpringBootBase   
 * fileName: TwoTable.java  
 * packageName: com.example.mikael.dao.twotable   
 * date: 2020-10-21
 * copyright(c) 2017-2020 xxx公司  
 */
package com.example.mikael.dao.twotable;

import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: mikael
 * @className: TwoTable
 * @packageName: com.example.mikael.dao.twotable
 * @description:
 * @data: 2020-10-21
 **/
public interface TwoTableDao {
    List<Map<String, Object>> selectFindall();

}
