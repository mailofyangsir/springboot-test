package com.core.pojo;

/**
 * Copyright
 * FileName: User
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/11 14:11
 * @since 1.0.0
 */

public class User {

    private Long id;
    private String username;
    private String password;
    private int age;
    private String address;

    public User() {
    }

    public User(Long id, String username, String password, int age, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
