package com.mybatis.pojo;

/**
 * @Classname Person
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-06-27 19:34
 * @Version 1.0
 **/
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;

    // 关联属性
    private Idcard idcard;

    @Override
    public String toString() {
        return "Person [id=" + id + "," +
                "name=" + name + ", " +
                "age=" + age + ", " +
                "sex=" + sex + "," +
                "idcard=" + idcard + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Idcard getIdcard() {
        return idcard;
    }

    public void setIdcard(Idcard idcard) {
        this.idcard = idcard;
    }
}
