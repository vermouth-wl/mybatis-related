package com.mybatis.test;

import com.mybatis.mapper.ClassMapper;
import com.mybatis.mapper.StudentMapper;
import com.mybatis.pojo.Clazz;
import com.mybatis.pojo.Student;
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

public class StudentTest {

    // SqlSessionFactory 工厂
    private SqlSessionFactory sqlSessionFactory;

    // SqlSession
    private SqlSession sqlSession;

    @Before
    public void init() {
        // 设置mybatis配置文件
        String resource = "mybatis-config.xml";

        // 文件流
        InputStream inputStream;

        try {
            // 从配置文件中获取文件流
            inputStream = Resources.getResourceAsStream(resource);

            // 从文件流中获取SqlSessionFactory 工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 从SqlSessionFactory工厂中打开sqlSession
            sqlSession = sqlSessionFactory.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 一对一查询测试方法，查询一个学生，其中对应一个班级信息
    @Test
    public void findStudentById() {
        // 获取接口代理
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        // 调用接口方法
        Student student = studentMapper.findStudentById(2);
        System.out.println(student.toString());
    }

    // 一对多查询测试方法，查询一个班级，其中对应多个学生信息
    @Test
    public void findClassStudentById() {
        // 获取接口代理
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);

        // 调用接口方法
        Clazz clazz = classMapper.findClassStudentById(4);
        System.out.println(clazz.studentInfo());
    }

    @After
    public void destroy() {
        // 提交事务
        sqlSession.commit();
        // 关闭事务
        sqlSession.close();
    }
}