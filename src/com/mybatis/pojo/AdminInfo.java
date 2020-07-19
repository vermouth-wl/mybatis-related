package com.mybatis.pojo;

import java.util.List;

/**
 * @Classname AdminInfo
 * @Description TODO 管理员类
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-07-19 19:09
 * @Version 1.0
 **/
public class AdminInfo {
    private Integer id;
    private String name;
    private List<Functions> functionsList;

    @Override
    public String toString() {
        return "AdminInfo[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "functions=" + functionsList + "]";
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

    public List<Functions> getFunctionsList() {
        return functionsList;
    }

    public void setFunctionsList(List<Functions> functionsList) {
        this.functionsList = functionsList;
    }
}
