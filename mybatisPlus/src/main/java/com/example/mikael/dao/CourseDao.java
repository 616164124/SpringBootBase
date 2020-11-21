package com.example.mikael.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mikael.entity.Course;

public interface CourseDao extends BaseMapper<Course> {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}