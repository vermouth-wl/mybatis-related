package com.mybatis.mapper;

import com.mybatis.pojo.Clazz;

import java.util.List;

public interface ClassMapper {
    Clazz findClassStudentById(Integer id);
    Clazz findClassStudentById2(Integer id);
}
