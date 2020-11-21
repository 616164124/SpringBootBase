package com.example.mikael.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mikael.entity.Test;
import org.springframework.stereotype.Component;

public interface TestDao extends BaseMapper<Test> {
    int deleteByPrimaryKey(Long id);

    @Override
    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}