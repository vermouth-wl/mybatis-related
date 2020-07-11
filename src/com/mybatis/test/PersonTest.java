package com.mybatis.test;

import com.mybatis.mapper.PersonMapper;
import com.mybatis.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class PersonTest {
    // 创建会话工厂及会话
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    @Before
    public void init() {
        // 读取mybatis配置文件
        String resource = "mybatis-config.xml";
        // 创建输入流
        InputStream inputStream;

        try {
            // 得到配置文件流
            inputStream = Resources.getResourceAsStream(resource);

            // 从配置流中获取并创建工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过会话工厂打开会话
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findPersonById() {
        // 获取PersonMapper接口的代理对象
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        Person person = mapper.findPersonById(1);
        System.out.println(person.getName());
    }

    @After
    public void destroy() {
        sqlSession.commit();
        sqlSession.close();
    }
}