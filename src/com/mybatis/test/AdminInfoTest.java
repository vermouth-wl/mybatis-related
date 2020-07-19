package com.mybatis.test;

import com.mybatis.mapper.AdminMapper;
import com.mybatis.pojo.AdminInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class AdminInfoTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init() {
        String resource = "mybatis-config.xml";
        InputStream inputStream;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAdminbyId() {
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        AdminInfo adminInfo = adminMapper.findAdminById(1);
        System.out.println(adminInfo.toString());
    }

    @After
    public void destroy() {
        sqlSession.commit();
        sqlSession.close();
    }

}