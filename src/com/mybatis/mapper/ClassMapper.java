package com.mybatis.mapper;

import com.mybatis.pojo.Clazz;

import java.util.List;

public interface ClassMapper {
    Clazz findClassStudentById(Integer id);
    List<Clazz> findClassStudentById2(Integer id);
    void addClass(Clazz clazz);
    int deleteClassById(Integer id);
}
