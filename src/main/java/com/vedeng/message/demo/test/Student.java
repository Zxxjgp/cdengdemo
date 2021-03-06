package com.vedeng.message.demo.test;

import lombok.Data;

import java.util.Date;

@Data
public class Student {

    //年龄
    private Integer age;
    //住址
    private String address;

    private Date data;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}