package com.vedeng.message.demo.test;

import java.util.Date;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/12 17:38
 * @Description //TODO
 * @version: 1.0
 */
public class Stu {
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
    public static void main(String[] args) {
        System.out.println("my name is 激光炮 ");
    }
}
