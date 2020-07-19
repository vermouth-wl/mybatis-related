package com.mybatis.mapper;

import com.mybatis.pojo.Student;

public interface StudentMapper {
    Student findStudentById(Integer id);
    void addStudents(Student student);
}
