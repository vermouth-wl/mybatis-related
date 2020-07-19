package com.mybatis.pojo;

/**
 * @Classname Functions
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-07-19 19:10
 * @Version 1.0
 **/
public class Functions {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Functions[" +
                "id=" + id + ", " +
                "name=" + name + "]";
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
}
