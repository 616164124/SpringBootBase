package com.example.mikael;

import com.example.mikael.dao.twotable.TwoTableDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class TwoTableDaoTest {

    @Resource
    private TwoTableDao twoTableDao;

    @Test
    public void selectTwotable() {
        List<Map<String, Object>> maps = twoTableDao.selectFindall();
        for (Map<String, Object> map : maps) {
            Set<String> set = map.keySet();
            for (String key : set) {
                System.out.println(map.get(key));
            }
        }

    }


}