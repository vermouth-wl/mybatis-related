package com.mybatis.pojo;

import java.util.List;

/**
 * @Classname Clazz
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-07-11 14:13
 * @Version 1.0
 **/
public class Clazz {
    private Integer id;
    private String clazzCode;
    private String clazzName;

    // 一对多关联集合属性
    private List<Student> studentList;

    @Override
    public String toString() {
        return "[编号: " + clazzCode + ", 名称: " + clazzName + "]";
    }

    public String studentInfo() {
        return "[编号: " + clazzCode + ", 名称: " + clazzName + ", 学生信息: [" + studentList + "]]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClazzCode() {
        return clazzCode;
    }

    public void setClazzCode(String clazzCode) {
        this.clazzCode = clazzCode;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
}
