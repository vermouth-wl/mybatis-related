package com.mybatis.pojo;

import java.util.Date;

/**
 * @Classname Student
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-07-11 14:04
 * @Version 1.0
 **/
public class Student {

    // 基础属性
    private Integer id;
    private String userCode;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date regDate;
    private Integer status;

    // 关联属性
    private Clazz classId;

    public Student() {}

    public String toString() {
        return "该学生的编码为: " + userCode + "" +
                ", 昵称为: " + userName + "" +
                ", 邮箱为: " + email + "" +
                ", 联系电话为: " + phone + "" +
                ", 地址为: " + address + "" +
                ", 班级为: " + classId ;
    }

    public String showMsg() {
        return "该学生的编码为: " + userCode + "" +
                ", 昵称为: " + userName + "" +
                ", 邮箱为: " + email + "" +
                ", 联系电话为: " + phone + "" +
                ", 地址为: " + address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Clazz getClassId() {
        return classId;
    }

    public void setClassId(Clazz classId) {
        this.classId = classId;
    }
}
