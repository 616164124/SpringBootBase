package com.example.mikael.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author mikael
 *
 * @create 2020/11/11
 */
@SpringBootTest
class TestDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(TestDaoTest.class);

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @Resource
    private TestDao testDao;
    @Resource
    private TransactionTemplate transactionTemplate;

    /** 批量插入 */
    @Test
    void insert() {
        SqlSession sqlSession =
                sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        TestDao mapper = sqlSession.getMapper(TestDao.class);
        for (int i = 0; i < 2000000; ++i) {
            com.example.mikael.entity.Test test = new com.example.mikael.entity.Test("hua" + i);
            mapper.insert(test);
            if (i % 1000 == 9) {
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
        sqlSession.close();
    }

    /** 分页查询 */
    @Test
    public void testPage() {

        Object execute =
                transactionTemplate.execute(
                        new TransactionCallback() {
                            @Override
                            public Object doInTransaction(TransactionStatus status) {
                                return null;
                            }

                            public Object doTransaction(TransactionStatus status) {

                                return null;
                            }
                        });

        int currentPage = 1;
        int pageSize = 5;
        String orderBy = "id desc";
        int count = testDao.selectCount(null);
        PageHelper.startPage(currentPage, pageSize, orderBy);
        List<com.example.mikael.entity.Test> users = testDao.selectList(null);
        PageInfo<com.example.mikael.entity.Test> userPageInfo = new PageInfo<>(users);
        logger.debug("【userPageInfo】= {}", userPageInfo);
    }

    @Test
    void deleteByPrimaryKey() {
        com.example.mikael.entity.Test test = testDao.selectByPrimaryKey(5L);
        logger.info(testDao.selectById(new Long(5)) + "");
    }

    class TestHashMap<K, V> extends LinkedHashMap<K, V> {
    }
}