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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

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

    // 一对多嵌套结果查询测试方法
    @Test
    public void findClassStudentById2() {
        // 获取接口代理对象
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        //List<Clazz> clazzList = sqlSession.selectList("findClassStudentById2", 4);
        // 调用接口方法
        List<Clazz> clazzes = classMapper.findClassStudentById2(4);
        clazzes.forEach(e -> System.out.println(e.studentInfo() + " "));
        //System.out.println(clazz.studentInfo());
    }

    // 添加测试插入方法，用于向班级表插入数据的同时向用户表插入信息
    @Test
    public void testAddStudent() {
        Clazz clazz = new Clazz();
        clazz.setClazzCode("110");
        clazz.setClazzName("高一（10）班");
        // 获取ClassMapper的接口代理对象
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        classMapper.addClass(clazz);

        // 创建学生对象
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setUserCode("Q001");
        student1.setUserName("琪琪");
        student1.setPassword("12345");
        student1.setName("齐琪");
        student1.setEmail("qq@163.com");
        student1.setPhone("88888888");
        student1.setAddress("妖皇洞");
        student1.setRegDate(new Date());
        student1.setStatus(1);
        // 设置关联属性
        student1.setClassId(clazz);

        student2.setUserCode("X002");
        student2.setUserName("轩轩");
        student2.setPassword("12345");
        student2.setName("凌之轩");
        student2.setEmail("xx@163.com");
        student2.setPhone("88888888");
        student2.setAddress("北京");
        student2.setRegDate(new Date());
        student2.setStatus(1);
        // 设置关联属性
        student2.setClassId(clazz);

        // 获取studentMapper的接口代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.addStudents(student1);
        studentMapper.addStudents(student2);
    }

    // 创建删除方法，删除班级及该班级下的学生
    @Test
    public void testDeleteClassById() {
        // 获取ClassMapper的接口代理对象
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        // 执行删除方法
        int result = classMapper.deleteClassById(7);
        if (result > 0) {
            System.out.println("执行删除成功");
        } else {
            System.out.println("执行删除失败");
        }
    }

    @After
    public void destroy() {
        // 提交事务
        sqlSession.commit();
        // 关闭事务
        sqlSession.close();
    }
}