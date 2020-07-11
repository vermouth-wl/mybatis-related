package com.mybatis.pojo;

/**
 * @Classname Idcard
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-06-27 19:33
 * @Version 1.0
 **/
public class Idcard {
    private Integer id;
    private String cno;

    @Override
    public String toString() {
        return "Idcard [id=" + id + "," +
                "cno=" + cno + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }
}
