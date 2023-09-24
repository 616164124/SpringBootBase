package com.mikael.web.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikael.web.demo.domain.admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author hua
* @description 针对表【admin】的数据库操作Mapper
* @createDate 2023-09-24 07:11:01
* @Entity generator.domain.admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<admin> {

    List<admin> selectAdmin();

}
