package com.choose.db.mybatis.model;

import java.io.Serializable;

/**
 * @className: User
 * @package: com.choose.db.mybatis.model
 * @describe: 实体类
 * @auther: liuzhiyong
 * @date: 2018/7/11
 * @time: 下午 3:10
 */
public class User implements Serializable{

    private int id;

    private String name;

    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("id = ");
        buffer.append(this.id);
        buffer.append("; name = ");
        buffer.append(this.name);
        buffer.append("; password = ");
        buffer.append(this.password);
        buffer.append("。 ");
        return buffer.toString();
    }
}
