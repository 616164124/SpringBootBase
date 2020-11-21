package com.example.mikael.dao;

import com.example.mikael.entity.Course;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest
class CourseDaoTest {
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    @Resource
    private CourseDao courseDao;

    @Test
    public void testCourseDao() {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        CourseDao mapper = sqlSession.getMapper(CourseDao.class);

        //学号
        int[] studentid = {1001,
                1002,
                1003,
                1004,
                1005,
                1011,
                1012,
                1013,
                1014,
                1015,
                1021,
                1022,
                1023};
        //课表
        int[] courseid = {1000,
                1001,
                1002,
                1003};
        for (int i = 1; i < 10000000; i++) {
            int studentRandom = ThreadLocalRandom.current().nextInt(13);
            int courseidRandom = ThreadLocalRandom.current().nextInt(4);
            String i1 = ThreadLocalRandom.current().nextInt(100) + "";
            Course course = new Course(i, studentid[studentRandom], courseid[courseidRandom], i1, new Date(System.currentTimeMillis()));
            mapper.insert(course);
            if (i % 1000 == 9) {
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
        sqlSession.close();
    }

    @Test
    public void testClass() throws ClassNotFoundException {
        //com.example.mikael.dao.CourseDao
        String s = new String();
        Class<?> aClass = Class.forName("com.example.mikael.dao.CourseDao");
        String name = aClass.getName();

    }

    @Test
    public void testBtch() throws IllegalAccessException, InstantiationException {
    }
}