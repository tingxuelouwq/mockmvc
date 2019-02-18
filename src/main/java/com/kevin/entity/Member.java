package com.kevin.entity;

/**
 * 类名: Member<br/>
 * 包名：com.kevin.entity<br/>
 * 作者：kevin<br/>
 * 时间：2019/2/18 11:15<br/>
 * 版本：1.0<br/>
 * 描述：
 */
public class Member {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private Integer age;

    public Member(Integer id, String name, String password, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
