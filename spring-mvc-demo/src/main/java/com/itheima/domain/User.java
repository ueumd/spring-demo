package com.itheima.domain;

public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name, Integer age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private Address address;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
